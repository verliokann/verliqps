package ru.verlioka.cmf.appservices.phonecalls.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.phonecalls.dao.concrete.myTableDao;
import ru.verlioka.cmf.appservices.phonecalls.models.myTableEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("myTableServiceImpl")
public class myTableServiceImpl extends GenericServiceImpl<myTableEntity, Long>
        implements myTableService {


    public myTableServiceImpl() {
    }

    @Autowired
    public myTableServiceImpl(myTableDao genericDao) {
        super(genericDao);
    }
}