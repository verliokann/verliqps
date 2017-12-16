package ru.verlioka.cmf.appservices.sidorova.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.sidorova.models.HelperModel;
import ru.verlioka.cmf.appservices.sidorova.models.PaperModel;
import ru.verlioka.cmf.appservices.sidorova.services.paper.PaperServiceImpl;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.type.Type;


@Repository ("paperDaoImpl")
public class PaperDaoImpl extends GenericDaoImpl <PaperModel,Integer> implements PaperDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List <PaperModel> getPapers() {
        Query query = entityManager.createQuery("select numberCompany, typeStock, dateEdition, nominalPriceStock " +
                "from PaperModel where nominalPriceStock>1000 and nominalPriceStock<2000" +
                "order by nominalPriceStock desc");
        List <PaperModel> paperModelList = query.getResultList();
        return paperModelList;
    }

    @Override
    public List<PaperModel> getPapersCrit() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria1 = session.createCriteria(PaperModel.class).add(Restrictions.lt("nominalPriceStock",2000)).add(Restrictions.gt("nominalPriceStock",1000)) ;
        return criteria1.list();
    }

    @Override
    public List<PaperModel> getCompany() {
        Query query = entityManager.createQuery("select numberCompany, sum (nominalPriceStock), sum (exchangeValue) " +
                "from PaperModel " +
                "group by numberCompany");
        List <PaperModel> paperModelList = query.getResultList();
        return paperModelList;
    }

    @Override
    public List<PaperModel> gerCompanyCrit() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();

        return session.createCriteria(PaperModel.class)
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("numberCompany"))
                        .add(Projections.sum("exchangeValue"))
                        .add(Projections.sum("nominalPriceStock"))

                ).list();
    }

    @Override
    public List<HelperModel> getStocks() {
        Query query = entityManager.createQuery("select nominalPriceStock, typeStock, percentAccrual, " +
                "(exchangeValue*(percentAccrual/100)) as sellingPrice " +
                "from PaperModel where numberCompany=2 " +
                "order by nominalPriceStock desc");
        List <HelperModel> helperModelList = query.getResultList();

        return helperModelList;
    }

}
