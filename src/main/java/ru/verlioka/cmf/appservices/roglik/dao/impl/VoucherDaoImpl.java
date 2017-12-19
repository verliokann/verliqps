package ru.verlioka.cmf.appservices.roglik.dao.impl;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.roglik.dao.interfaces.VoucherDao;
import ru.verlioka.cmf.appservices.roglik.models.VoucherEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("voucherDaoImpl")
public class VoucherDaoImpl extends GenericDaoImpl<VoucherEntity, Long> implements VoucherDao {
    @PersistenceContext
    private EntityManager em;

    public VoucherDaoImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
