package ru.verlioka.cmf.appservices.sales.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.sales.models.vidTovaraEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("vidTovaraDaoImpl")
public class vidTovaraDaoImpl extends GenericDaoImpl<vidTovaraEntity, Long>
        implements vidTovaraDao {

}