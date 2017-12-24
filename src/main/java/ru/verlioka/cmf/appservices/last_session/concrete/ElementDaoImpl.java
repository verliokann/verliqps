package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.last_session.model.ElementEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("ElementDaoImpl")
public class ElementDaoImpl extends GenericDaoImpl<ElementEntity, Long>
        implements ElementDao {
}
