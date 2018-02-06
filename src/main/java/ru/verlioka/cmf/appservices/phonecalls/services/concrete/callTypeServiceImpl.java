package ru.verlioka.cmf.appservices.phonecalls.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.phonecalls.dao.concrete.callTypeDao;
import ru.verlioka.cmf.appservices.phonecalls.models.callTypeEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("callTypeServiceImpl")
public class callTypeServiceImpl extends GenericServiceImpl<callTypeEntity, Long>
        implements callTypeService {


    public callTypeServiceImpl() {
    }

    @Autowired
    public callTypeServiceImpl(callTypeDao genericDao) {
        super(genericDao);
    }
}