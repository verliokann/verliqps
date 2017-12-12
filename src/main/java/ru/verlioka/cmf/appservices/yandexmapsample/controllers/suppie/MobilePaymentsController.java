package ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.BalanceReport;
import ru.verlioka.cmf.appservices.yandexmapsample.controllers.suppie.json.PaymentsReport;
import ru.verlioka.cmf.appservices.yandexmapsample.services.suppie.CustomerService;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/suppie")
public class MobilePaymentsController {
    private final CustomerService customerService;

    private final ObjectMapper mapper;

    public MobilePaymentsController(CustomerService customerService) {
        Objects.requireNonNull(customerService);

        this.customerService = customerService;

        this.mapper = new ObjectMapper();
        this.mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }

    @RequestMapping("/payments")
    public List<PaymentsReport> getPaymentReports() {
        return customerService.getPaymentReports();
    }

    @RequestMapping("/balances")
    public List<BalanceReport> getBalanceReports() {
        return customerService.getBalanceReports();
    }
}
