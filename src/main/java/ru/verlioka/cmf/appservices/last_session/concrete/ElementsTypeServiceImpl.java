package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.last_session.model.ElementsTypeEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("ElementTypeServiceImpl")
public class ElementsTypeServiceImpl extends GenericServiceImpl<ElementsTypeEntity, Long>
        implements ElementsTypeService {

    public ElementsTypeServiceImpl() {
    }

    @Autowired
    public ElementsTypeServiceImpl(ElementsTypeDao genericDao) {
        super(genericDao);
    }
}
