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

	@SuppressWarnings("unchecked")
	@Override
	public List<VouchersEntity> getVouchersByRating(int rating) {
		Query query = em.createQuery("from VouchersEntity where rating = :Rating");
        query.setParameter("Rating", rating);
        return query.getResultList();
	}

}
