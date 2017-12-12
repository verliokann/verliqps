package ru.verlioka.cmf.appservices.suppie.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.suppie.models.CustomerEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("customerDaoImpl")
public class CustomerDaoImpl extends GenericDaoImpl<CustomerEntity, Long> implements CustomerDao {
    public CustomerDaoImpl() {
    }
}
