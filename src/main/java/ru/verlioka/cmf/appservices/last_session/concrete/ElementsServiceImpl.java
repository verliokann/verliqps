package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.last_session.model.ElementsEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("ElementsServiceImpl")
public class ElementsServiceImpl extends GenericServiceImpl<ElementsEntity, Long>
        implements ElementsService {


    public ElementsServiceImpl() {
    }

    @Autowired
    public ElementsServiceImpl(ElementsDao genericDao) {
        super(genericDao);
    }
}
