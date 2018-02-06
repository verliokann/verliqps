package ru.verlioka.cmf.appservices.mudrichenko.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.mudrichenko.models.CriminalCasesEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("criminalCasesDaoImpl")
public class CriminalCasesDaoImpl extends GenericDaoImpl<CriminalCasesEntity, Long>
        implements CriminalCasesDao {
}
