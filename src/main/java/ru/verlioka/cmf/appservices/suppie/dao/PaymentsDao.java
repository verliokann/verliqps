package ru.verlioka.cmf.appservices.suppie.dao;

import ru.verlioka.cmf.appservices.suppie.models.PaymentsEntity;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

import java.util.List;

public interface PaymentsDao extends IGenericDao<PaymentsEntity, Long> {
    List<PaymentsEntity> getPaymentsByCustomerId(Long customerId);
}
