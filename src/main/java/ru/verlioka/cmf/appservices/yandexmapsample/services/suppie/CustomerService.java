package ru.verlioka.cmf.appservices.yandexmapsample.services.suppie;

import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.BalanceReport;
import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.PaymentsReport;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.CustomerEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface CustomerService extends IGenericService<CustomerEntity, Long> {
    List<PaymentsReport> getPaymentsReport(Long customerId);

    List<BalanceReport> getBalanceReport(Long customerId);

    List<PaymentsReport> getPaymentReports();

    List<BalanceReport> getBalanceReports();
}
