package ru.verlioka.cmf.appservices.DureevDS.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.DureevDS.dao.concrete.AggregationDao;
import ru.verlioka.cmf.appservices.DureevDS.model.AggregationEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("AggregationDaoImpl")
public class AggregationDaoImpl extends GenericDaoImpl<AggregationEntity, Long>
        implements AggregationDao {
}
