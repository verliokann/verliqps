package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.last_session.model.ElementEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("providersServiceImpl")
public class ElementServiceImpl extends GenericServiceImpl<ElementEntity, Long>
        implements ElementService {

    public ElementServiceImpl() {
    }

    @Autowired
    public ElementServiceImpl(ElementDao genericDao) {
        super(genericDao);
    }
}
