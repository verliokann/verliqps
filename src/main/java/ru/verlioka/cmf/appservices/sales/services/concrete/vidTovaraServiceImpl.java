package ru.verlioka.cmf.appservices.sales.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.sales.dao.concrete.vidTovaraDao;
import ru.verlioka.cmf.appservices.sales.models.vidTovaraEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("myTableServiceImpl")
public class vidTovaraServiceImpl extends GenericServiceImpl<vidTovaraEntity, Long>
        implements vidTovaraService {


    public vidTovaraServiceImpl() {
    }

    @Autowired
    public vidTovaraServiceImpl(vidTovaraDao genericDao) {
        super(genericDao);
    }
}