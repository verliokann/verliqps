package ru.verlioka.cmf.appservices.mudrichenko.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.mudrichenko.models.CriminalArticlesEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("criminalArticlesDaoImpl")
public class CriminalArticlesDaoImpl extends GenericDaoImpl<CriminalArticlesEntity, Long>
        implements CriminalArticlesDao {
}
