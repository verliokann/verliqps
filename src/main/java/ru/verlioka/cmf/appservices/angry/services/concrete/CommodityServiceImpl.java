package ru.verlioka.cmf.appservices.angry.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.angry.dao.concrete.CommodityDao;
import ru.verlioka.cmf.appservices.angry.model.CommodityEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("commodityServiceImpl")
public class CommodityServiceImpl extends GenericServiceImpl<CommodityEntity, Long>
        implements CommodityService {


    public CommodityServiceImpl() {
    }

    @Autowired
    public CommodityServiceImpl(CommodityDao genericDao) {
        super(genericDao);
    }
}
