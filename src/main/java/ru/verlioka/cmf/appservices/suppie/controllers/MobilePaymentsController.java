package ru.verlioka.cmf.appservices.suppie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.suppie.controllers.json.BalanceReport;
import ru.verlioka.cmf.appservices.suppie.controllers.json.PaymentsReport;
import ru.verlioka.cmf.appservices.suppie.services.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/suppie")
public class MobilePaymentsController {
    @Autowired
    private CustomerService customerService;

    public MobilePaymentsController() {
    }

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public @ResponseBody
    List<PaymentsReport> getPaymentReports() {
        return customerService.getPaymentReports();
    }

    @RequestMapping(value = "/payments/{customerId}", method = RequestMethod.GET)
    public @ResponseBody
    List<PaymentsReport> getPaymentReports(@PathVariable Long customerId) {
        return customerService.getPaymentsReport(customerId);
    }

    @RequestMapping(value = "/balances", method = RequestMethod.GET)
    public @ResponseBody
    List<BalanceReport> getBalanceReports() {
        return customerService.getBalanceReports();
    }

    @RequestMapping(value = "/balances/{customerId}", method = RequestMethod.GET)
    public @ResponseBody
    List<BalanceReport> getBalanceReports(@PathVariable Long customerId) {
        return customerService.getBalanceReport(customerId);
    }
}
