package ru.verlioka.cmf.appservices.rudenko.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.MidLengthVoucher;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VouchersOverallReview;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VouchersWithVisaRequired;
import ru.verlioka.cmf.appservices.rudenko.services.VoucherService;

import java.util.List;

@Controller
@RequestMapping("/rudenko")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    public VoucherController() {
    }

    @RequestMapping(value = "/midlength", method = RequestMethod.GET)
    public @ResponseBody
    List<MidLengthVoucher> getAllMidLengthVouchers(@RequestParam(value = "min", required = false) Integer lowerBound, @RequestParam(value = "max", required = false) Integer upperBound) {
        return voucherService.getAllMidLengthVouchers(
                lowerBound == null ? Integer.MIN_VALUE : lowerBound,
                upperBound == null ? Integer.MAX_VALUE : upperBound
        );
    }

    @RequestMapping(value = "/visa", method = RequestMethod.GET)
    public @ResponseBody
    List<VouchersWithVisaRequired> getVouchersWithVisaRequired() {
        return voucherService.getVouchersWithVisaRequired();
    }

    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public @ResponseBody
    VouchersOverallReview getVouchersReview() {
        return voucherService.getVouchersReview();
    }
}
