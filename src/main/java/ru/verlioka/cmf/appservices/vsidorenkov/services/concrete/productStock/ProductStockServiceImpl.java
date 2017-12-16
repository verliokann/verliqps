package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.productStock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.ProductStockDao;
import ru.verlioka.cmf.appservices.vsidorenkov.models.ProductStock;
import ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.productStock.ProductStockService;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("ProductStockServiceImpl")
public class ProductStockServiceImpl extends GenericServiceImpl<ProductStock, Long>
        implements ProductStockService {



    public ProductStockServiceImpl() {
    }

    @Autowired
    public ProductStockServiceImpl(ProductStockDao genericDao) {
        super(genericDao);
    }
}
