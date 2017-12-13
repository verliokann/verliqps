package ru.verlioka.cmf.appservices.presnyakov.services.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.presnyakov.dao.Material.MaterialDao;
import ru.verlioka.cmf.appservices.presnyakov.dao.Provider.ProviderDao;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.appservices.presnyakov.models.Provider;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("providerServiceImpl")
public class ProviderServiceImpl extends GenericServiceImpl<Provider, Long>
        implements ProviderService {


    public ProviderServiceImpl() {
    }

    @Autowired
    public ProviderServiceImpl(ProviderDao genericDao) {
        super(genericDao);
    }
}
