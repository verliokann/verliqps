package ru.verlioka.cmf.appservices.phonecalls.controllers;


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
import ru.verlioka.cmf.appservices.phonecalls.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.phonecalls.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.phonecalls.controllers.Criteria.CriteriaRequest3;
import ru.verlioka.cmf.appservices.phonecalls.models.callTypeEntity;
import ru.verlioka.cmf.appservices.phonecalls.models.myTableEntity;
import ru.verlioka.cmf.appservices.phonecalls.models.cityEntity;

import ru.verlioka.cmf.appservices.phonecalls.services.concrete.callTypeService;
import ru.verlioka.cmf.appservices.phonecalls.services.concrete.cityService;
import ru.verlioka.cmf.appservices.phonecalls.services.concrete.myTableService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Controller
@EnableTransactionManagement
@RequestMapping("/phonecalls")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private myTableService myTableService;
    @Autowired
    private cityService cityService;
    @Autowired
    private callTypeService callTypeService;

    private String hql_request_1 = "select \n"
            +"\tmyTableEntity.id as id,\n"
            +"\tmyTableEntity.phoneNumber as phone_number,\n"
            +"\tmyTableEntity.length as call_length,\n"
            +"\tcity.cityName as city_name \n"
            +"from myTableEntity as myTableEntity \n"
            +"inner join myTableEntity.city as city \n"
            +"where myTableEntity.length>15 \n"
            +"order by myTableEntity.phoneNumber";

    private String hql_request_2 = "select \n"
            +"\tmyTableEntity.phoneNumber as phone_number,\n"
            +"\tmyTableEntity.length as call_length,\n"
            +"from myTableEntity as myTableEntity \n"
            +"inner join myTableEntity.city as city \n"
            +"where myTableEntity.city.Id = 1";

    private String hql_request_3 = "select \n"
            +"\tcityTable.cityDestination as city \n"
            +"sum(myTable.callDuration) as total_call_duration \n"
            +"group by city \n"+
            "order by city";

    @RequestMapping(value = "/myTable", method = RequestMethod.GET)
    public
    @ResponseBody
    List<myTableEntity> getAll_() {
        List<myTableEntity> rlist = myTableService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/cityTable", method = RequestMethod.GET)
    public
    @ResponseBody
    List<cityEntity> getAll_city() {
        List<cityEntity> rlist = cityService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/callType", method = RequestMethod.GET)
    public
    @ResponseBody
    List<callTypeEntity> getAll_type() {
        List<callTypeEntity> rlist = callTypeService.getAll();
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

    @RequestMapping(value = "/request_hql_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request3_hql() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(hql_request_3);
        return query.list();
    }

    @RequestMapping(value = "/request_criteria_1", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request1_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(myTableEntity.class,"myTableEntity");
                criteria.createAlias("myTableEntity.city","city");
                        criteria.setProjection(
                                        Projections.projectionList()
                                         .add(Projections.property("myTableEntity.phoneNumber"),"phoneNumber")
                                        .add(Projections.property("myTableEntity.length"),"callLength")
                                        .add(Projections.property("city.cityName"),"cityDestination")

                        );
                        criteria.add(Restrictions.ge("myTableEntity.length",Long.valueOf(15)));



        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {

        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(myTableEntity.class,"myTableEntity");
        criteria.createAlias("myTableEntity.city","city");
        criteria.createAlias("myTableEntity.type","type");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("myTableEntity.phoneNumber"),"phoneNumber")
                        .add(Projections.property("myTableEntity.length"),"callLength")
                        .add(Projections.property("type.price"),"pricePerMinute")
                        .add(Projections.sqlProjection(
                              "(select price from myTableEntity.type as total_price)",
                                new String[]{"total_price"},
                                 new Type[]{new LongType()}),
                                   "total_price")

        );

        criteria.add(Restrictions.eq("city.Id",Long.valueOf(1)));



        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();

    }

    @RequestMapping(value = "/request_criteria_3", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request3_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(myTableEntity.class,"myTable");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("cityTable.cityDestination"),"city")

                        .add(Projections.sqlProjection(
                                "(select (myTable.callDuration) as total_call_duration",
                                new String[]{"total_call_duration"},
                                new Type[]{new LongType()}),
                                "total_call_duration")
        );


        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }

}