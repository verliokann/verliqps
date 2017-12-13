package ru.verlioka.cmf.appservices.angry.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.angry.dao.concrete.ProvidersDao;
import ru.verlioka.cmf.appservices.angry.model.ProvidersEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("providersServiceImpl")
public class ProvidersServiceImpl extends GenericServiceImpl<ProvidersEntity, Long>
        implements ProvidersService  {

    public ProvidersServiceImpl() {
    }

    @Autowired
    public ProvidersServiceImpl(ProvidersDao genericDao) {
        super(genericDao);
    }
}
