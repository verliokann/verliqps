package ru.verlioka.cmf.appservices.zverevvv.services.concrete;

import ru.verlioka.cmf.appservices.zverevvv.controllers.reports.BankBranchReport;
import ru.verlioka.cmf.appservices.zverevvv.controllers.reports.CustomerReport;
import ru.verlioka.cmf.appservices.zverevvv.models.ClientEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;
import java.util.UUID;

public interface ClientService extends IGenericService<ClientEntity, UUID> {
    List<CustomerReport> getCustomersReportCriteria();

    List<BankBranchReport> getBankBranchReportCriteria();

    List<CustomerReport> getCustomersReportHQL();

    List<BankBranchReport> getBankBranchReportHQL();
}
