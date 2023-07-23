package ru.verlioka.cmf.appservices.sales.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.sales.dao.concrete.sotrudnikiDao;
import ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("sotrudnikiServiceImpl")
public class sotrudnikiServiceImpl extends GenericServiceImpl<sotrudnikiEntity, Long>
        implements sotrudnikiService {


    public sotrudnikiServiceImpl() {
    }

    @Autowired
    public sotrudnikiServiceImpl(sotrudnikiDao genericDao) {
        super(genericDao);
    }
}