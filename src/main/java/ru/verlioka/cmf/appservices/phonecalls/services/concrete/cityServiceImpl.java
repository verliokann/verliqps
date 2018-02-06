package ru.verlioka.cmf.appservices.phonecalls.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.phonecalls.dao.concrete.cityDao;
import ru.verlioka.cmf.appservices.phonecalls.models.cityEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("cityServiceImpl")
public class cityServiceImpl extends GenericServiceImpl<cityEntity, Long>
        implements cityService {


    public cityServiceImpl() {
    }

    @Autowired
    public cityServiceImpl(cityDao genericDao) {
        super(genericDao);
    }
}