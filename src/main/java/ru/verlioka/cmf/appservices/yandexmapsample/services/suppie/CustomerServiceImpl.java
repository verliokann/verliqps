package ru.verlioka.cmf.appservices.yandexmapsample.services.suppie;

import com.google.common.util.concurrent.AtomicDouble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.BalanceReport;
import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.PaymentsReport;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie.CustomerDao;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie.PaymentsDao;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie.TariffDao;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.CustomerEntity;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.PaymentsEntity;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.TariffEntity;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service("customerServiceImpl")
public class CustomerServiceImpl extends CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    private static final Calendar CONVERTER = Calendar.getInstance();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM yyyy");

    public CustomerServiceImpl(CustomerDao dao, PaymentsDao paymentsDao, TariffDao tariffDao) {
        super(dao, paymentsDao, tariffDao);
    }

    @Override
    public List<PaymentsReport> getPaymentsReport(Long customerId) {
        if (customerId == null || customerId < 0) {
            log.error("Customer ID " + customerId + " is invalid.");
            return Collections.emptyList();
        }

        final CustomerEntity customer = getCustomerDao().find(customerId);

        if (customer == null) {
            log.error("Customer with ID: " + customerId + " was not found.");
            return Collections.emptyList();
        }

        final TariffEntity customerTariff = customer.getTariff();

        if (customerTariff == null) {
            log.error("Customer tariff was not found.");
            return Collections.emptyList();
        }

        List<BalanceReport> balanceReports = getBalanceReport(customerId);

        return balanceReports.stream()
                .map(balanceReport -> {
                    Integer minutesAmount = -1;

                    if (customerTariff.getMinutesPerMonth() != -1) {
                        if (balanceReport.getDebtAmount() > 0) {
                            minutesAmount = 0;
                        } else {
                            minutesAmount = customerTariff.getMinutesPerMonth();
                        }
                    }

                    PaymentsReport report = new PaymentsReport();
                    report.setPhoneNumber(balanceReport.getPhoneNumber());
                    report.setName(balanceReport.getName());
                    report.setAddress(customer.getAddress());
                    report.setMonth(balanceReport.getMonth());
                    report.setPaymentsAmount(balanceReport.getPaymentsAmount());
                    report.setMinutesAmount(minutesAmount);
                    return report;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<BalanceReport> getBalanceReport(Long customerId) {
        if (customerId == null || customerId < 0) {
            log.error("Customer ID " + customerId + " is invalid.");
            return Collections.emptyList();
        }

        final CustomerEntity customer = getCustomerDao().find(customerId);

        if (customer == null) {
            log.error("Customer with ID: " + customerId + " was not found.");
            return Collections.emptyList();
        }

        final TariffEntity customerTariff = customer.getTariff();

        if (customerTariff == null) {
            log.error("Customer tariff was not found.");
            return Collections.emptyList();
        }

        final List<PaymentsEntity> customerPayments = getPaymentsDao().getPaymentsByCustomerId(customer.getId());

        if (customerPayments == null || customerPayments.isEmpty()) {
            log.info("Payments from customer with ID " + customerId + " were not found.");
            return Collections.emptyList();
        }

        TreeMap<String, List<PaymentsEntity>> paymentsMap = new TreeMap<>();
        for (PaymentsEntity payment : customerPayments) {
            CONVERTER.setTime(payment.getCreatedAt());
            String key = DATE_FORMAT.format(CONVERTER);

            paymentsMap.putIfAbsent(key, new ArrayList<>());
            paymentsMap.get(key).add(payment);
        }

        final AtomicDouble debt = new AtomicDouble();
        debt.set(Double.MIN_VALUE);

        return paymentsMap.entrySet()
                .stream()
                .map(monthlyPayments -> {
                    Double payment = monthlyPayments.getValue().stream().mapToDouble(PaymentsEntity::getAmount).sum();
                    Double previousDebt = debt.get();

                    if (previousDebt == Double.MIN_VALUE) {
                        debt.set(payment - customerTariff.getMonthlyPayment());
                    } else {
                        debt.set(payment - (customerTariff.getMonthlyPayment() + previousDebt));
                    }

                    BalanceReport report = new BalanceReport();
                    report.setPhoneNumber(customer.getPhoneNumber());
                    report.setName(customer.getName());
                    report.setMonth(monthlyPayments.getKey());
                    report.setRequiredToPay(customerTariff.getMonthlyPayment());
                    report.setDebtAmount(debt.get());
                    report.setPaymentsAmount(payment);

                    return report;
                })
                .collect(Collectors.toList());
    }
}
