package ru.verlioka.cmf.appservices.sales.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.sales.dao.concrete.tovarDao;
import ru.verlioka.cmf.appservices.sales.models.tovarEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("tovarServiceImpl")
public class tovarServiceImpl extends GenericServiceImpl<tovarEntity, Long>
        implements tovarService {


    public tovarServiceImpl() {
    }

    @Autowired
    public tovarServiceImpl(tovarDao genericDao) {
        super(genericDao);
    }
}