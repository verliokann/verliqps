package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.productType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.ProductTypeDao;
import ru.verlioka.cmf.appservices.vsidorenkov.models.ProductType;
import ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.productType.ProductTypeService;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl extends GenericServiceImpl<ProductType, Long>
        implements ProductTypeService {


    public ProductTypeServiceImpl() {
    }

    @Autowired
    public ProductTypeServiceImpl(ProductTypeDao genericDao) {
        super(genericDao);
    }
}
