package ru.verlioka.cmf.appservices.zverevvv.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.zverevvv.models.ClientEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import java.util.UUID;


@Repository("clientDaoImpl")
public class ClientDaoImpl extends GenericDaoImpl<ClientEntity, UUID> implements ClientDao {

}
