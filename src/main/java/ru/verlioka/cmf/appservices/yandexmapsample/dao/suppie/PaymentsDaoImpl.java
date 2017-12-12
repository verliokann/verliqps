package ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.PaymentsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("paymentDaoImpl")
public class PaymentsDaoImpl extends PaymentsDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<PaymentsEntity> getPaymentsByCustomerId(Long customerId) {
        Query query = em.createQuery("from PaymentsEntity where customer.id = :customerId");
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}
