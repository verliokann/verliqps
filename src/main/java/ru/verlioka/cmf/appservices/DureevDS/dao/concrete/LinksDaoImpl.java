package ru.verlioka.cmf.appservices.DureevDS.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.DureevDS.model.LinksEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("LinksDaoImpl")
public class LinksDaoImpl extends GenericDaoImpl<LinksEntity, Long>
        implements LinksDao {

}
