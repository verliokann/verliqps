package ru.verlioka.cmf.appservices.mudrichenko.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.mudrichenko.dao.concrete.DefendantsDao;
import ru.verlioka.cmf.appservices.mudrichenko.models.DefendantsEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("defendantsTypeServiceImpl")
public class DefendantsServiceImpl extends GenericServiceImpl<DefendantsEntity, Long>
        implements DefendantsService {

    public DefendantsServiceImpl() {
    }

    @Autowired
    public DefendantsServiceImpl(DefendantsDao genericDao) {
        super(genericDao);
    }
}
