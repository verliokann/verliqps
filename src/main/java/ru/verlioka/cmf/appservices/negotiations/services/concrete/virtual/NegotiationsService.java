package ru.verlioka.cmf.appservices.negotiations.services.concrete.virtual;

import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.appservices.negotiations.models.SubscribeTable;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface NegotiationsService extends IGenericService<NegotiationsTable, Long> {
    List<NegotiationsTable> getAllNegotiations();
    NegotiationsTable getNegotiation(Long id);

    List<SubscribeTable> getAllSubscribers();
    List<SubscribeTable> getSubscribersByNegotiation(Long id);
}
