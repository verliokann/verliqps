package ru.verlioka.cmf.appservices.suppie.services;

import ru.verlioka.cmf.appservices.suppie.controllers.json.BalanceReport;
import ru.verlioka.cmf.appservices.suppie.controllers.json.PaymentsReport;
import ru.verlioka.cmf.appservices.suppie.models.CustomerEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface CustomerService extends IGenericService<CustomerEntity, Long> {
    List<PaymentsReport> getPaymentsReport(Long customerId);

    List<BalanceReport> getBalanceReport(Long customerId);

    List<PaymentsReport> getPaymentReports();

    List<BalanceReport> getBalanceReports();
}
