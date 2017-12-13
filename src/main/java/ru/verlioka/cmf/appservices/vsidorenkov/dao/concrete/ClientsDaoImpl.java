package ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Clients;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("ClientsDaoImpl")
public class ClientsDaoImpl extends GenericDaoImpl<Clients, Long>
        implements ClientsDao {

}
