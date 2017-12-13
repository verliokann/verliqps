package ru.verlioka.cmf.appservices.angry.controllers;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.angry.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.angry.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.angry.model.CommodityEntity;
import ru.verlioka.cmf.appservices.angry.model.CommodityTypeEntity;
import ru.verlioka.cmf.appservices.angry.model.ProvidersEntity;
import ru.verlioka.cmf.appservices.angry.model.SupplyEntity;
import ru.verlioka.cmf.appservices.angry.services.concrete.CommodityService;
import ru.verlioka.cmf.appservices.angry.services.concrete.CommodityTypeService;
import ru.verlioka.cmf.appservices.angry.services.concrete.ProvidersService;
import ru.verlioka.cmf.appservices.angry.services.concrete.SupplyService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Controller
@EnableTransactionManagement
@RequestMapping("/angry")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityTypeService commodityTypeService;
    @Autowired
    private ProvidersService providersService;
    @Autowired
    private SupplyService supplyService;

    private String hql_request_1 = "select \n" +
            "\tcommodity.name as Commodity_name,\n" +
            "\tcommodity.description as Commodity_description,\n" +
            "\tcommodity.unit as Unit,\n" +
            "\tcommodity.price as Price_per_unit,\n" +
            "\tprovider.name as Provider_name,\n" +
            "\tprovider.city as Provider_city,\n" +
            "\tprovider.country as Provider_country,\n" +
            "\tprovider.phone as Provider_phone,\n" +
            "\tprovider.fax as Provider_fax,\n" +
            "\tsupply.shipments_are_stopped as  Supply_isShipments_are_stopped,\n" +
            "\tsupply.count as Supply_count,\n" +
            "\tsupply.price as Supply_price,\n" +
            "\tsupply.date as Supply_date\n" +
            "from SupplyEntity as supply \n" +
            "inner join supply.commodity as commodity \n" +
            "inner join supply.provider as provider";

    private String hql_request_2 = "select \n" +
            "\ttype.name as CommodityType_name,\n" +
            "\tcommodity.name as Commodity_name,\n" +
            "\tcommodity.description as Commodity_description,\n" +
            "\t(select sum(supply.count) from SupplyEntity as supply where supply.commodity = commodity)\n" +
            "from CommodityEntity as commodity\n" +
            "inner join commodity.type as type";

    @RequestMapping(value = "/commodity_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommodityEntity> getAll_commodity() {
        List<CommodityEntity> rlist = commodityService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/commodity_type_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommodityTypeEntity> getAll_type() {
        List<CommodityTypeEntity> rlist = commodityTypeService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/providers_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProvidersEntity> getAll_providers() {
        List<ProvidersEntity> rlist = providersService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/supply_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SupplyEntity> getAll_supply() {
        List<SupplyEntity> rlist = supplyService.getAll();
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
        Criteria criteria = session.createCriteria(SupplyEntity.class,"supply");

        criteria.createAlias("supply.commodity","commodity");
        criteria.createAlias("supply.provider","provider");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("commodity.name"),"commodity_name")
                        .add(Projections.property("commodity.description"),"commodity_description")
                        .add(Projections.property("commodity.unit"),"commodity_unit")
                        .add(Projections.property("commodity.price"),"commodity_price")
                        .add(Projections.property("provider.name"),"provider_name")
                        .add(Projections.property("provider.city"),"provider_country")
                        .add(Projections.property("provider.country"),"provider_city")
                        .add(Projections.property("provider.phone"),"provider_phone")
                        .add(Projections.property("provider.fax"),"provider_fax")
                        .add(Projections.property("supply.shipments_are_stopped"),"supply_shipments_are_stopped")
                        .add(Projections.property("supply.count"),"supply_count")
                        .add(Projections.property("supply.price"),"supply_price")
                        .add(Projections.property("supply.date"),"supply_date")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CommodityEntity.class,"commodity");

        criteria.createAlias("commodity.type","type");
        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("type.name"),"type_name")
                        .add(Projections.property("commodity.name"),"commodity_name")
                        .add(Projections.property("commodity.description"),"commodity_description")
                        .add(Projections.sqlProjection(
                                "(select SUM(entry.count) from supply as entry where entry.commodity_id = this_.id) as commodity_count",
                                new String[]{"commodity_count"},
                                new Type[]{new LongType()}),
                                "commodity_count")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }


}
