package ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie;

import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.PaymentsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import java.util.List;

public abstract class PaymentsDao extends GenericDaoImpl<PaymentsEntity, Long> {
    public abstract List<PaymentsEntity> getPaymentsByCustomerId(Long customerId);
}
