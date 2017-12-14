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
    private SubscribeDao subscribeDao;

    @Autowired
    private NegotiationsDao negotiationsDao;

    public NegotiationsServiceImpl() {
    }

    @Autowired
    public NegotiationsServiceImpl(NegotiationsDao genericDao) {
        super(genericDao);
    }

    @Override
    public List getSubscribersByNegotiationQuery(Long id) {
        return negotiationsDao.getSubscribeByNegotiationQuery(id);
    }

    @Override
    public List getSubscribeByNegotiationCriteria(Long id) {
        return negotiationsDao.getSubscribeByNegotiationCriteria(id);
    }

    @Override
    public List getNegotiationsQuery(Long id) {
        return negotiationsDao.getNegotiationsQuery(id);
    }

    @Override
    public List getNegotiationCriteria(Long id) {
        return negotiationsDao.getNegotiationCriteria(id);
    }
}
