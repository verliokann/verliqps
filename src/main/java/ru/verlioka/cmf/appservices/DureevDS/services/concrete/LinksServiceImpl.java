package ru.verlioka.cmf.appservices.DureevDS.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.DureevDS.dao.concrete.LinksDao;
import ru.verlioka.cmf.appservices.DureevDS.model.LinksEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("LinksServiceImpl")
public class LinksServiceImpl extends GenericServiceImpl<LinksEntity, Long>
        implements LinksService {


    public LinksServiceImpl() {
    }

    @Autowired
    public LinksServiceImpl(LinksDao genericDao) {
        super(genericDao);
    }
}
