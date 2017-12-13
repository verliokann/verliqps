package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.ClientsDao;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Clients;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("ClientsServiceImpl")
public class ClientsServiceImpl extends GenericServiceImpl<Clients, Long>
        implements ClientsService {


    public ClientsServiceImpl() {
    }

    @Autowired
    public ClientsServiceImpl(ClientsDao genericDao) {
        super(genericDao);
    }
}
