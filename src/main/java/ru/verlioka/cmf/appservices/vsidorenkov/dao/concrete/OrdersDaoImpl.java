package ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Orders;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("OrdersDaoImpl")
public class OrdersDaoImpl extends GenericDaoImpl<Orders, Long>
        implements OrdersDao {

}
