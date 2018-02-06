package ru.verlioka.cmf.appservices.mudrichenko.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.mudrichenko.models.DefendantsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("defendantsTypeDaoImpl")
public class DefendantsDaoImpl extends GenericDaoImpl<DefendantsEntity, Long>
        implements DefendantsDao {
}
