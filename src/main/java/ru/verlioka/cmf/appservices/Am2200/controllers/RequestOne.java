package ru.verlioka.cmf.appservices.Am2200.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportOne;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportThree;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportTwo;
import ru.verlioka.cmf.appservices.Am2200.models.VouchersEntity;
import ru.verlioka.cmf.appservices.Am2200.services.VouchersService;
import ru.verlioka.cmf.appservices.Am2200.services.VouchersServiceImpl;

import java.util.*;

@Controller
@RequestMapping("/am2200")
public class RequestOne {

    public RequestOne() {

    }

    @Autowired
    VouchersService vouchersService;

    @RequestMapping(value = "/getReportOneCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportOne> getReportOneCriteria() {
        return vouchersService.getReportOneCriteria();
    }

    @RequestMapping(value = "/getReportOneHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportOne> getReportOneHQL() {
        return vouchersService.getReportOneHQL();
    }

    @RequestMapping(value = "/getReportTwoCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportTwo> getReportTwoCriteria() {
        return vouchersService.getReportTwoCriteria();
    }

    @RequestMapping(value = "/getReportTwoHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportTwo> getReportTwoHQL() {
        return vouchersService.getReportTwoHQL();
    }

    @RequestMapping(value = "/getReportThreeCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportThree> getReportThreeCriteria() {
        return vouchersService.getReportThreeCriteria();
    }

    @RequestMapping(value = "/getReportThreeHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<ReportThree> getReportThreeHQL() {
        return vouchersService.getReportThreeHQL();
    }

}
