package ru.verlioka.cmf.appservices.mudrichenko.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.mudrichenko.dao.concrete.CriminalArticlesDao;
import ru.verlioka.cmf.appservices.mudrichenko.models.CriminalArticlesEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("criminalArticlesEntityServiceImpl")
public class CriminalArticlesEntityServiceImpl extends GenericServiceImpl<CriminalArticlesEntity, Long>
        implements CriminalArticlesEntityService {

    public CriminalArticlesEntityServiceImpl() {
    }

    @Autowired
    public CriminalArticlesEntityServiceImpl(CriminalArticlesDao genericDao) {
        super(genericDao);
    }
}
