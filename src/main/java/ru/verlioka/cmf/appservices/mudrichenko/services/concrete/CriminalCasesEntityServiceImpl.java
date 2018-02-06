package ru.verlioka.cmf.appservices.mudrichenko.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.mudrichenko.dao.concrete.CriminalCasesDao;
import ru.verlioka.cmf.appservices.mudrichenko.models.CriminalCasesEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("criminalCasesEntityServiceImpl")
public class CriminalCasesEntityServiceImpl extends GenericServiceImpl<CriminalCasesEntity, Long>
        implements CriminalCasesEntityService {

    public CriminalCasesEntityServiceImpl() {
    }

    @Autowired
    public CriminalCasesEntityServiceImpl(CriminalCasesDao genericDao) {
        super(genericDao);
    }
}
