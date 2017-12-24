package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.last_session.model.ElementsTypeEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("ElementTypeDaoImpl")
public class ElementTypeDaoImpl extends GenericDaoImpl<ElementsTypeEntity, Long>
        implements ElementsTypeDao {
}
