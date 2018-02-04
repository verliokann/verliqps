package ru.verlioka.cmf.appservices.decay.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.decay.dao.concrete.jobDao;
import ru.verlioka.cmf.appservices.decay.model.jobEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("jobServiceImpl")
public class jobServiceImpl extends GenericServiceImpl<jobEntity, Long>
        implements jobService {


    public jobServiceImpl() {
    }

    @Autowired
    public jobServiceImpl(jobDao genericDao) {
        super(genericDao);
    }
}