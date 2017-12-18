package ru.verlioka.cmf.appservices.negotiations.dao.concrete;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("NegotiationsDaoImpl")
public class NegotiationsDaoImpl extends GenericDaoImpl<NegotiationsTable, Long>
        implements NegotiationsDao {

    @PersistenceContext
    private EntityManager em;

    private static final String GET_SUBSCRIBER_BY_NEGOT =
            "select subscribe.id, subscribe.Name, subscribe.Surname, negotiations.Place, negotiations.Type, negotiations.NumberOfMinutes, negotiations.Date, negotiations.Cost " +
                    "from SubscribeTable subscribe, NegotiationsTable negotiations" +
                    " where subscribe.negotiations = negotiations and negotiations.id = :id";

    @Override
    public List getSubscribeByNegotiationQuery(Long id) {
        Query query = em.createQuery(GET_SUBSCRIBER_BY_NEGOT);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List getSubscribeByNegotiationCriteria(Long id) {
        Session session = ((Session) em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(NegotiationsTable.class, "negotiations");
        criteria.createAlias("subscribe.negotiations", "negotiations");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("subscribe.id"), "id")
                .add(Projections.property("subscribe.Name"), "Name")
                .add(Projections.property("subscribe.Surname"), "Surname")
                .add(Projections.property("negotiations.Place"), "Place")
                .add(Projections.property("negotiations.Type"), "Type")
                .add(Projections.property("negotiations.NumberOfMinutes"), "NumberOfMinutes")
                .add(Projections.property("negotiations.Date"), "Date")
                .add(Projections.property("negotiations.Cost"), "Cost")
        );
        criteria.add(Restrictions.eq("negotiations.id", id));
        return criteria.list();
    }

    @Override
    public List getNegotiationsQuery(Long id) {
        Query query = em.createQuery("from NegotiationsTable where id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List getNegotiationCriteria(Long id) {
        Session session = ((Session) em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(NegotiationsTable.class, "negotiations");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("negotiations.id"), "id")
                .add(Projections.property("negotiations.Type"), "Type")
                .add(Projections.property("negotiations.Tarrif"), "Tarrif")
        );
        criteria.add(Restrictions.eq("negotiations.id", id));
        return criteria.list();
    }
}
