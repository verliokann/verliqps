package ru.verlioka.cmf.appservices.angry.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.angry.model.ProvidersEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("providersDaoImpl")
public class ProvidersDaoImpl extends GenericDaoImpl<ProvidersEntity, Long>
        implements ProvidersDao  {
}
