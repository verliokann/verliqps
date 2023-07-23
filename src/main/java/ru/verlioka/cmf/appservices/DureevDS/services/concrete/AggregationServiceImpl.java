package ru.verlioka.cmf.appservices.DureevDS.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.DureevDS.dao.concrete.AggregationDao;
import ru.verlioka.cmf.appservices.DureevDS.model.AggregationEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("AggregationServiceImpl")
public class AggregationServiceImpl extends GenericServiceImpl<AggregationEntity, Long>
        implements AggregationService {

    public AggregationServiceImpl() {
    }

    @Autowired
    public AggregationServiceImpl(AggregationDao genericDao) {
        super(genericDao);
    }
}
