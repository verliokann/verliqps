package ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Order_Products;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("Orders_ProductsDaoImpl")
public class Orders_ProductsDaoImpl extends GenericDaoImpl<Order_Products, Long>
        implements Order_ProductsDao {

}
