package ru.verlioka.cmf.appservices.Am2200.dao;

import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportOne;
import ru.verlioka.cmf.appservices.Am2200.models.VouchersEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("vouchersDaoImpl")
public class VouchersDaoImpl extends GenericDaoImpl<VouchersEntity, Integer> implements VouchersDao {
    public VouchersDaoImpl() {

    }
}
