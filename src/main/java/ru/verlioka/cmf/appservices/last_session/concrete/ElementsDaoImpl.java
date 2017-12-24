package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.last_session.model.ElementsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("ElementsDaoImpl")
public class ElementsDaoImpl extends GenericDaoImpl ElementsEntity, Long>
        implements ElementsDao {

}
