package ru.verlioka.cmf.appservices.angry.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.angry.model.SupplyEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("supplyDaoImpl")
public class SupplyDaoImpl extends GenericDaoImpl<SupplyEntity, Long>
        implements SupplyDao  {
}
