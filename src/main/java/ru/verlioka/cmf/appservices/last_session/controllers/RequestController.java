package ru.verlioka.cmf.appservices.last_session.controllers;

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
import ru.verlioka.cmf.appservices.last_session.concrete.ElementsService;
import ru.verlioka.cmf.appservices.last_session.concrete.SupplyService;
import ru.verlioka.cmf.appservices.last_session.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.last_session.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.last_session.model.CommodityEntity;
import ru.verlioka.cmf.appservices.last_session.model.ElementsTypeEntity;
import ru.verlioka.cmf.appservices.last_session.model.ElementEntity;
import ru.verlioka.cmf.appservices.last_session.model.SupplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@EnableTransactionManagement
@RequestMapping("/angry")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ElementsService ElementsService;
    @Autowired
    private ElementsTypeService ElementsTypeService;
    @Autowired
    private ElementService ElementService;
    @Autowired
    private SupplyService supplyService;

    private String hql_request_1 = "select \n" +
            "\tElements.name as Elements_name,\n" +
            "\tElements.description as Elements_description,\n" +
            "\tElements.unit as Unit,\n" +
            "\tElements.price as Price_per_unit,\n" +
            "\tElement.name as Element_name,\n" +
            "\tElement.city as Element_city,\n" +
            "\tElement.country as Element_country,\n" +
            "\tElement.phone as Element_phone,\n" +
            "\tElement.fax as Element_fax,\n" +
            "\tsupply.shipments_are_stopped as  Supply_isShipments_are_stopped,\n" +
            "\tsupply.count as Supply_count,\n" +
            "\tsupply.price as Supply_price,\n" +
            "\tsupply.date as Supply_date\n" +
            "from SupplyEntity as supply \n" +
            "inner join supply.Elements as Elements \n" +
            "inner join supply.Element as Element";

    private String hql_request_2 = "select \n" +
            "\ttype.name as ElementsType_name,\n" +
            "\tElements.name as Elements_name,\n" +
            "\tElements.description as Elements_description,\n" +
            "\t(select sum(supply.count) from SupplyEntity as supply where supply.Elements = Elements)\n" +
            "from ElementsEntity as Elements\n" +
            "inner join Elements.type as type";

    @RequestMapping(value = "/Elements_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ElementsEntity> getAll_Elements() {
        List<ElementsEntity> rlist = ElementsService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/Elements_type_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ElementsTypeEntity> getAll_type() {
        List<ElementsTypeEntity> rlist = ElementsTypeService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/Element_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ElementEntity> getAll_Element() {
        List<ElementEntity> rlist = ElementService.getAll();
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
                        .add(Projections.property("Elements.name"),"Elements_name")
                        .add(Projections.property("Elements.description"),"Elements_description")
                        .add(Projections.property("Elements.unit"),"Elements_unit")
                        .add(Projections.property("Elements.price"),"Elements_price")
                        .add(Projections.property("Element.name"),"Element_name")
                        .add(Projections.property("Element.city"),"Element_country")
                        .add(Projections.property("Element.country"),"Element_city")
                        .add(Projections.property("Element.phone"),"Element_phone")
                        .add(Projections.property("Element.fax"),"Element_fax")
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
        Criteria criteria = session.createCriteria(CommodityEntity.class,"Elements");

        criteria.createAlias("Elements.type","type");
        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("type.name"),"type_name")
                        .add(Projections.property("Elements.name"),"Elements_name")
                        .add(Projections.property("Elements.description"),"Elements_description")
                        .add(Projections.sqlProjection(
                                "(select SUM(entry.count) from supply as entry where entry.Elements_id = this_.id) as Elements_count",
                                new String[]{"Elements_count"},
                                new Type[]{new LongType()}),
                                "Elements_count")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }


}
