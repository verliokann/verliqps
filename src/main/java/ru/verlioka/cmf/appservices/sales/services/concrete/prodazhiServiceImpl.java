package ru.verlioka.cmf.appservices.sales.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.sales.dao.concrete.prodazhiDao;
import ru.verlioka.cmf.appservices.sales.models.prodazhiEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("prodazhiServiceImpl")
public class prodazhiServiceImpl extends GenericServiceImpl<prodazhiEntity, Long>
        implements prodazhiService {


    public prodazhiServiceImpl() {
    }

    @Autowired
    public prodazhiServiceImpl(prodazhiDao genericDao) {
        super(genericDao);
    }
}