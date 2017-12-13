package ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.vsidorenkov.models.ProductStock;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("ProductStockDaoImpl")
public class ProductStockDaoImpl extends GenericDaoImpl<ProductStock, Long>
        implements ProductStockDao {

}
