package ru.verlioka.cmf.appservices.angry.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.angry.dao.concrete.CommodityTypeDao;
import ru.verlioka.cmf.appservices.angry.model.CommodityTypeEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("commodityTypeServiceImpl")
public class CommodityTypeServiceImpl extends GenericServiceImpl<CommodityTypeEntity, Long>
        implements CommodityTypeService  {

    public CommodityTypeServiceImpl() {
    }

    @Autowired
    public CommodityTypeServiceImpl(CommodityTypeDao genericDao) {
        super(genericDao);
    }
}
