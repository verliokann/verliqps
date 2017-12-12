package ru.verlioka.cmf.appservices.yandexmapsample.services.suppie;

import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.BalanceReport;
import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.PaymentsReport;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie.CustomerDao;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie.PaymentsDao;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie.TariffDao;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.CustomerEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CustomerService extends GenericServiceImpl<CustomerEntity, Long> {
    private final PaymentsDao paymentsDao;
    private final TariffDao tariffDao;

    public CustomerService(CustomerDao dao, PaymentsDao paymentsDao, TariffDao tariffDao) {
        super(dao);
        this.paymentsDao = paymentsDao;
        this.tariffDao = tariffDao;
    }

    public CustomerDao getCustomerDao() {
        return (CustomerDao) getGenericDao();
    }

    public PaymentsDao getPaymentsDao() {
        return paymentsDao;
    }

    public TariffDao getTariffDao() {
        return tariffDao;
    }

    public abstract List<PaymentsReport> getPaymentsReport(Long customerId);

    public abstract List<BalanceReport> getBalanceReport(Long customerId);

    @SuppressWarnings("unchecked")
    public List<PaymentsReport> getPaymentReports() {
        return getCustomerDao().getAll()
                .stream()
                .map(customer -> getPaymentsReport(((CustomerEntity) customer).getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public List<BalanceReport> getBalanceReports() {
        return getCustomerDao().getAll()
                .stream()
                .map(customer -> getBalanceReport(((CustomerEntity) customer).getId()))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
