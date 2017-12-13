package ru.verlioka.cmf.appservices.zverevvv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.zverevvv.controllers.reports.BankBranchReport;
import ru.verlioka.cmf.appservices.zverevvv.controllers.reports.CustomerReport;
import ru.verlioka.cmf.appservices.zverevvv.services.concrete.ClientService;

import java.util.List;

@Controller
@RequestMapping("/zverevvv")
public class MobileBankController {

    @Autowired
    private ClientService clientService;

    public MobileBankController() {
    }

    @RequestMapping(value = "/customersReportCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<CustomerReport> getCustomersReportCriteria() {
        return clientService.getCustomersReportCriteria();
    }

    @RequestMapping(value = "/customersReportHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<CustomerReport> getCustomersReportHQL() {
        return clientService.getCustomersReportHQL();
    }

    @RequestMapping(value = "/bankBranchReportCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<BankBranchReport> getBankBranchReportCriteria() {
        return clientService.getBankBranchReportCriteria();
    }

    @RequestMapping(value = "/bankBranchReportHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<BankBranchReport> getBankBranchReportHQL() {
        return clientService.getBankBranchReportHQL();
    }
}
