package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.order_products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.Order_ProductsDao;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Order_Products;
import ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.order_products.Order_ProductsService;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("Order_ProductsServiceImpl")
public class Order_ProductsServiceImpl extends GenericServiceImpl<Order_Products, Long>
        implements Order_ProductsService {


    public Order_ProductsServiceImpl() {
    }

    @Autowired
    public Order_ProductsServiceImpl(Order_ProductsDao genericDao) {
        super(genericDao);
    }
}
