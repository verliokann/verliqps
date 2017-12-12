package ru.verlioka.cmf.appservices.angry.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.angry.model.CommodityTypeEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("commodityTypeDaoImpl")
public class CommodityTypeDaoImpl extends GenericDaoImpl<CommodityTypeEntity, Long>
        implements CommodityTypeDao {
}
