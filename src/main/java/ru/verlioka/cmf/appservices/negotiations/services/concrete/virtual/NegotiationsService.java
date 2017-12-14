package ru.verlioka.cmf.appservices.negotiations.services.concrete.virtual;

import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.appservices.negotiations.models.SubscribeTable;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface NegotiationsService extends IGenericService<NegotiationsTable, Long> {

    List getSubscribersByNegotiationQuery(Long id);
    List getSubscribeByNegotiationCriteria(Long id);

    List getNegotiationsQuery(Long id);
    List getNegotiationCriteria(Long id);
}
