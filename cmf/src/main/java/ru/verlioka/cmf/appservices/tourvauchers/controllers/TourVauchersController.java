package ru.verlioka.cmf.appservices.tourvauchers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/byratingHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<HotelReport> getAllRatingVouchers(@RequestParam(value = "rating", required = false) Integer hotelRating) {
        return voucherService.getVouchersByRatingHQL(hotelRating);
    }
	
	@RequestMapping(value = "/byratingCRI", method = RequestMethod.GET)
    public @ResponseBody
    List<HotelReport> getAllRatingVouchersCriteria(@RequestParam(value = "rating", required = false) Integer hotelRating) {
        return voucherService.getVouchersByRatingCRI(
                hotelRating == null ? Integer.MIN_VALUE : hotelRating
        );
    }
	
	
	@RequestMapping(value = "/bymonthHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<VoucherReport> getAllMonthVouchers(@RequestParam(value = "start", required = false) Integer startMonth, @RequestParam(value = "finish", required = false) Integer finishMonth) {
        return voucherService.getAllMidMonthsVouchersHQL(startMonth,finishMonth);
    }
	
	@RequestMapping(value = "/bymonthCRI", method = RequestMethod.GET)
    public @ResponseBody
    List<VoucherReport> getAllMonthVouchersCriteria(@RequestParam(value = "start", required = false) Integer startMonth, @RequestParam(value = "finish", required = false) Integer finishMonth) {
        return voucherService.getAllMidMonthsVouchersCRI(startMonth,finishMonth);
    }
}
