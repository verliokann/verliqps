package ru.verlioka.cmf.appservices.tourvauchers.dao;

import java.util.List;

import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

public interface VoucherDao extends IGenericDao<VouchersEntity, Long>{
	
	List<VouchersEntity> getVouchersByRating(int rating);

}
