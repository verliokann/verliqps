package ru.verlioka.cmf.appservices.roglik.dao.interfaces;

import ru.verlioka.cmf.appservices.roglik.models.VoucherEntity;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

import javax.persistence.EntityManager;

public interface VoucherDao extends IGenericDao<VoucherEntity, Long> {
    EntityManager getEntityManager();
}
