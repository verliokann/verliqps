package ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie;

import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.PaymentsEntity;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

import java.util.List;

public interface PaymentsDao extends IGenericDao<PaymentsEntity, Long> {
    List<PaymentsEntity> getPaymentsByCustomerId(Long customerId);
}
