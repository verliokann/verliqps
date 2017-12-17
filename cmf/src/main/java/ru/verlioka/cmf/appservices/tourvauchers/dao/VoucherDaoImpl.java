package ru.verlioka.cmf.appservices.tourvauchers.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ru.verlioka.cmf.appservices.tourvauchers.models.VouchersEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("voucherDaoImpl")
public class VoucherDaoImpl extends GenericDaoImpl<VouchersEntity, Long> implements VoucherDao{
	
	@PersistenceContext
    private EntityManager em;

    public VoucherDaoImpl() {
    }

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

}
