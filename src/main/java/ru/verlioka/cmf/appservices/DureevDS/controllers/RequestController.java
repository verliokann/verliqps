package ru.verlioka.cmf.appservices.DureevDS.controllers;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.DureevDS.services.concrete.LinksService;
import ru.verlioka.cmf.appservices.DureevDS.services.concrete.AggregationService;
import ru.verlioka.cmf.appservices.DureevDS.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.DureevDS.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.DureevDS.model.LinksEntity;
import ru.verlioka.cmf.appservices.DureevDS.model.AggregationEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@EnableTransactionManagement
@RequestMapping("/DureevDS")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private LinksService LinksService;
    @Autowired
    private AggregationService AggregationService;

    private String hql_request_1 = "select \n" +
            "\tlink.name as Name,\n" +
            "\tlink.description as Description,\n" +
            "\tlink.unit as Unit,\n" +
            "\tlink.price as Price,\n" +
            "\taggregation.count as Aggregation_count,\n" +
            "\taggregation.price as Aggregation_price,\n" +
            "\taggregation.sale_date as Aggregation_sale_date\n" +
            "from AggregationEntity as aggregation \n" +
            "inner join aggregation.links as links";

    private String hql_request_2 = "select \n" +
            "\tcommodity.name as Commodity_name,\n" +
            "\tcommodity.description as Commodity_description,\n" +
            "\t(select sum(supply.count) from SupplyEntity as supply where supply.commodity = commodity)\n" +
            "from CommodityEntity as commodity\n" +
            "inner join commodity.type as type";

    @RequestMapping(value = "/links_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<LinksEntity> getAll_links() {
        List<LinksEntity> rlist = LinksService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/aggregation_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<AggregationEntity> getAll_aggregation() {
        List<AggregationEntity> rlist = AggregationService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/request_hql_1", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request1_hql() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(hql_request_1);
        return query.list();
    }

    @RequestMapping(value = "/request_hql_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_hql() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(hql_request_2);
        return query.list();
    }

    @RequestMapping(value = "/request_criteria_1", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request1_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AggregationEntity.class,"aggregation");

        criteria.createAlias("aggregation.links","links");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("links.name"),"links_name")
                        .add(Projections.property("links.description"),"links_description")
                        .add(Projections.property("links.unit"),"links_unit")
                        .add(Projections.property("links.price"),"links_price")
                        .add(Projections.property("aggregation.count"),"aggregation_count")
                        .add(Projections.property("aggregation.price"),"aggregation_price")
                        .add(Projections.property("aggregation.sale_date"),"aggregation_sale_date")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(AggregationEntity.class,"aggregation");

        criteria.createAlias("aggregation.links","type");
        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("aggregation.id"),"aggregation_id")
                        .add(Projections.property("links.name"),"links_name")
                        .add(Projections.property("links.manufacturer"),"links_manufacturer")
                        .add(Projections.property("links.supplier"),"links_supplier")
                        .add(Projections.sqlProjection(
                                "(select SUM(entry.count) from aggregation as entry where entry.aggregation__id = this_.id) as links_count",
                                new String[]{"links_count"},
                                new Type[]{new LongType()}),
                                "links_count")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }


}
