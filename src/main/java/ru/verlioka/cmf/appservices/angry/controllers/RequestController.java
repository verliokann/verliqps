package ru.verlioka.cmf.appservices.angry.controllers;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    



}
