package ru.verlioka.cmf.appservices.negotiations.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.negotiations.models.SubscribeTable;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("SubscribeDaoImpl")

public class SubscribeDaoImpl extends GenericDaoImpl<SubscribeTable, Long>
        implements SubscribeDao {

}