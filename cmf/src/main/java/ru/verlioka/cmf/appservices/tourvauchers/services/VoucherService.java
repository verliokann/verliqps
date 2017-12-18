package ru.verlioka.cmf.appservices.tourvauchers.services;

import java.util.Date;
import java.util.List;

import ru.verlioka.cmf.appservices.tourvauchers.controllers.HotelReport;
import ru.verlioka.cmf.appservices.tourvauchers.controllers.VoucherReport;
import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

public interface VoucherService extends IGenericService<VouchersEntity, Long>{
		
	List<VoucherReport> getAllMidMonthsVouchersHQL(Integer startMonth, Integer finishMonth);

    List<HotelReport> getVouchersByRatingHQL(Integer rating);
    
    List<VoucherReport> getAllMidMonthsVouchersCRI(Integer startMonth, Integer finishMonth);
    
    List<HotelReport> getVouchersByRatingCRI(Integer rating);
    	
}
