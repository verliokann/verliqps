package ru.verlioka.cmf.appservices.angry.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.angry.model.CommodityEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("commodityDaoImpl")
public class CommodityDaoImpl extends GenericDaoImpl<CommodityEntity, Long>
        implements CommodityDao {

}
