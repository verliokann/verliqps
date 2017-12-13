package ru.verlioka.cmf.appservices.rudenko.dao.impl;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.rudenko.dao.interfaces.VoucherDao;
import ru.verlioka.cmf.appservices.rudenko.models.VoucherEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("voucherDaoImpl")
public class VoucherDaoImpl extends GenericDaoImpl<VoucherEntity, Long> implements VoucherDao {
    public VoucherDaoImpl() {
    }
}
