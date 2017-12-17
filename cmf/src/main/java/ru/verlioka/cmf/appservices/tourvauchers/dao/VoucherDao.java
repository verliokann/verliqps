package ru.verlioka.cmf.appservices.tourvauchers.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

public interface VoucherDao extends IGenericDao<VouchersEntity, Long>{
	EntityManager getEntityManager();
}
