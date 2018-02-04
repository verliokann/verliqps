package ru.verlioka.cmf.appservices.decay.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.decay.dao.concrete.peopleDao;
import ru.verlioka.cmf.appservices.decay.model.peopleEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("commodityTypeServiceImpl")
public class peopleServiceImpl extends GenericServiceImpl<peopleEntity, Long>
        implements peopleService  {

    public peopleServiceImpl() {
    }

    @Autowired
    public peopleServiceImpl(peopleDao genericDao) {
        super(genericDao);
    }
}