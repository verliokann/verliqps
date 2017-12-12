package ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.CustomerEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("customerDaoImpl")
public class CustomerDaoImpl extends GenericDaoImpl<CustomerEntity, Long> implements CustomerDao {
    public CustomerDaoImpl() {
    }
}
