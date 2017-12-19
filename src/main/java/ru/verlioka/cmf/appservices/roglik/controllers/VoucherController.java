package ru.verlioka.cmf.appservices.roglik.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.roglik.controllers.json.BeachTypes;
import ru.verlioka.cmf.appservices.roglik.controllers.json.CertainBeachVouchers;
import ru.verlioka.cmf.appservices.roglik.controllers.json.LowCostVouchers;
import ru.verlioka.cmf.appservices.roglik.services.VoucherService;

import java.util.List;

@Controller
@RequestMapping("/roglik")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    public VoucherController() {
    }

    @RequestMapping(value = "/lowcost", method = RequestMethod.GET)
    public @ResponseBody
    List<LowCostVouchers> getVouchersBelowCertainPrice(@RequestParam("price") Integer price) {
        return voucherService.getVouchersBelowCertainPrice(price);
    }

    @RequestMapping(value = "/beach", method = RequestMethod.GET)
    public @ResponseBody
    CertainBeachVouchers getVouchersByBeachType(@RequestParam("beachType") String beachType) {
        return voucherService.getVouchersByBeachType(beachType);
    }

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public @ResponseBody
    List<BeachTypes> getBeachReport() {
        return voucherService.getBeachReport();
    }
}
