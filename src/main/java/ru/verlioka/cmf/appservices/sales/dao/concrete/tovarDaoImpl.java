package ru.verlioka.cmf.appservices.sales.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.sales.models.tovarEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("tovarDaoImpl")
public class tovarDaoImpl extends GenericDaoImpl<tovarEntity, Long>
        implements tovarDao {

}