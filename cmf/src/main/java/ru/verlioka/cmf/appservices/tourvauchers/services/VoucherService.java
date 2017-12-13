package ru.verlioka.cmf.appservices.tourvauchers.services;

import java.util.Date;
import java.util.List;

import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

public interface VoucherService extends IGenericService<VouchersEntity, Long>{
		
	List<VouchersEntity> getVouchersFromCategory();

}
