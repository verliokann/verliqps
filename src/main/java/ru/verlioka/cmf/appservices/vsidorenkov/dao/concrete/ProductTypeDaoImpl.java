package ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.vsidorenkov.models.ProductType;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository("ProductTypeDaoImpl")
public class ProductTypeDaoImpl extends GenericDaoImpl<ProductType, Long>
        implements ProductTypeDao {

}
