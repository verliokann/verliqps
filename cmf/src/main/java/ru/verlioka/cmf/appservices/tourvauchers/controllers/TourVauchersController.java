package ru.verlioka.cmf.appservices.tourvauchers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.appservices.tourvauchers.services.VoucherService;

@Controller
@RequestMapping("/tourvauchers")
public class TourVauchersController {
	
	@Autowired
    private VoucherService voucherService;
	
	public TourVauchersController() {
		
	}

	@RequestMapping(value = "/byrating", method = RequestMethod.GET)
    public @ResponseBody
    List<VouchersEntity> getPaymentReports() {
        return voucherService.getVouchersFromCategory();
    }
	
}
