package ru.verlioka.cmf.appservices.presnyakov.dao.Provider;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Provider;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("providerDaoImpl")
public class ProviderDaoImpl extends GenericDaoImpl<Provider, Long>
        implements ProviderDao {

}
