package ru.verlioka.cmf.appservices.negotiations.services.concrete.virtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.negotiations.dao.concrete.NegotiationsDao;
import ru.verlioka.cmf.appservices.negotiations.dao.concrete.SubscribeDao;
import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.appservices.negotiations.models.SubscribeTable;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.concrete.VirtualObjectDao;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service("NegotiationsServiceImpl")
public class NegotiationsServiceImpl extends GenericServiceImpl<NegotiationsTable, Long>
        implements NegotiationsService {


    @Autowired
    SubscribeDao subscribeDao;

    public NegotiationsServiceImpl() {
    }

    @Autowired
    public NegotiationsServiceImpl(NegotiationsDao genericDao) {
        super(genericDao);
    }


    @Override
    public List<NegotiationsTable> getAllNegotiations() {
        return getAll();
    }

    @Override
    public NegotiationsTable getNegotiation(Long id) {
        return find(id);
    }

    @Override
    public List<SubscribeTable> getAllSubscribers() {
        return subscribeDao.getAll();
    }

    @Override
    public List<SubscribeTable> getSubscribersByNegotiation(Long id) {
        return subscribeDao.getSubscribeByNegotiation(id);
    }
}
