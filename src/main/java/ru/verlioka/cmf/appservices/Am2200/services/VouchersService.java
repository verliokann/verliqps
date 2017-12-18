package ru.verlioka.cmf.appservices.Am2200.services;


import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportOne;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportThree;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportTwo;
import ru.verlioka.cmf.appservices.Am2200.models.VouchersEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface VouchersService extends IGenericService<VouchersEntity, Integer> {
    List<ReportOne> getReportOneCriteria();
    List<ReportOne> getReportOneHQL();

    List<ReportTwo> getReportTwoCriteria();
    List<ReportTwo> getReportTwoHQL();

    List<ReportThree> getReportThreeCriteria();
    List<ReportThree> getReportThreeHQL();
}
