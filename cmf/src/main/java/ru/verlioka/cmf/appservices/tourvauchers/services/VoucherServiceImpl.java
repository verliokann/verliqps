package ru.verlioka.cmf.appservices.tourvauchers.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.verlioka.cmf.appservices.tourvauchers.dao.VoucherDao;
import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("voucherServiceImpl")
public class VoucherServiceImpl extends GenericServiceImpl<VouchersEntity, Long> implements VoucherService{

	private static final Logger log = LoggerFactory.getLogger(VoucherService.class);
	
	public VoucherDao dao;

	public VoucherServiceImpl() {
		
	}
	
	@Autowired
	public VoucherServiceImpl(VoucherDao dao)
	{
		super(dao);
		this.dao = dao;
	}

	@Override
	public List<VouchersEntity> getVouchersFromCategory() {
		
		return dao.getVouchersByRating(3);
	}
	


}
