package ru.verlioka.cmf.appservices.negotiations.dao.concrete;

import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.appservices.negotiations.models.SubscribeTable;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

import java.util.List;

public interface NegotiationsDao extends IGenericDao<NegotiationsTable, Long> {
    List getSubscribeByNegotiationQuery(Long id);
    List getSubscribeByNegotiationCriteria(Long id);

    List getNegotiationsQuery(Long id);
    List getNegotiationCriteria(Long id);


}
