package ru.verlioka.cmf.appservices.sales.controllers;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.sales.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.sales.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.sales.models.tovarEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Controller
@EnableTransactionManagement
@RequestMapping("/sales")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ru.verlioka.cmf.appservices.sales.services.concrete.vidTovaraService vidTovaraService;
    @Autowired
    private ru.verlioka.cmf.appservices.sales.services.concrete.tovarService tovarService;
    @Autowired
    private ru.verlioka.cmf.appservices.sales.services.concrete.sotrudnikiService sotrudnikiService;
    @Autowired
    private ru.verlioka.cmf.appservices.sales.services.concrete.prodazhiService prodazhiService;

    private String hql_request_1 = "select \n"
            +"\tsotrudniki.FIO as FIO,\n"
            +"\tprodazhi.id as id,\n"
            +"\ttovar.nazvanie as nazvanie,\n"
            +"\tprodazhi.stoimost as stoimost \n"
            +"\tprodazhi.dataZakaza as dataZakaza \n"
            +"\tvidTovara.vid as vid \n"
            +"from sotrudnikiEntity as sotrudnikiEntity \n"
            +"inner join prodazhiEntity as prodazhiEntity \n"
            +"inner join tovarEntity as tovarEntity \n"
            +"inner join vidTovaraEntity as vidTovaraEntity \n";

    private String hql_request_2 = "select \n"
            +"\tsotrudniki.FIO as FIO,\n"
            +"\tsotrudniki.adress as adress,\n"
            +"\tsotrudniki.birthDate as birthDate,\n"
            +"\tsotrudniki.obrazovanie as obrazovanie,\n"
            +"\tsotrudniki.dolzhnost as dolzhnost,\n"
            +"\tsotrudniki.telefon as telefon,\n"
            +"from sotrudnikiEntity as sotrudnikiEntity \n";


    @RequestMapping(value = "/vidTovara", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ru.verlioka.cmf.appservices.sales.models.vidTovaraEntity> getAll_vidTovara() {
        List<ru.verlioka.cmf.appservices.sales.models.vidTovaraEntity> rlist = vidTovaraService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/tovar", method = RequestMethod.GET)
    public
    @ResponseBody
    List<tovarEntity> getAll_tovar() {
        List<tovarEntity> rlist = tovarService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/sotrudniki", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity> getAll_sotrudniki() {
        List<ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity> rlist = sotrudnikiService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/prodazhi", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ru.verlioka.cmf.appservices.sales.models.prodazhiEntity> getAll_prodazhi() {
        List<ru.verlioka.cmf.appservices.sales.models.prodazhiEntity> rlist = prodazhiService.getAll();
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
        Criteria criteria = session.createCriteria(ru.verlioka.cmf.appservices.sales.models.prodazhiEntity.class,"prodazhiEntity");
                criteria.createAlias("prodazhiEntity.stoimost","stoimost");
                        criteria.setProjection(
                                        Projections.projectionList()
                                         .add(Projections.property("sotrudniki.FIO"),"FIO")
                                        .add(Projections.property("prodazhi.id"),"id")
                                        .add(Projections.property("tovar.nazvanie"),"nazvanie")
                                                .add(Projections.property("prodazhi.dataZakaza"),"dataZakaza")
                                                .add(Projections.property("vidTovara.vid"),"vid")

                        );
                        criteria.add(Restrictions.ge("prodazhiEntity.stoimost",Long.valueOf(15)));


        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {

        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity.class,"sotrudnikiEntity");
        criteria.createAlias("sotrudnikiEntity.FIO","FIO");
        criteria.createAlias("sotrudnikiEntity.adress","adress");
        criteria.createAlias("sotrudnikiEntity.birthDate","birthDate");
        criteria.createAlias("sotrudnikiEntity.obrazovanie","obrazovanie");
        criteria.createAlias("sotrudnikiEntity.dolzhnost","dolzhnost");
        criteria.createAlias("sotrudnikiEntity.telefon","telefon");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("sotrudnikiEntity.FIO"),"FIO")
                        .add(Projections.property("sotrudnikiEntity.adress"),"adress")
                        .add(Projections.property("sotrudnikiEntity.birthDate"),"birthDate")
                        .add(Projections.property("sotrudnikiEntity.obrazovanie"),"obrazovanie")
                        .add(Projections.property("sotrudnikiEntity.dolzhnost"),"dolzhnost")
                        .add(Projections.property("sotrudnikiEntity.telefon"),"telefon")
        );

        criteria.add(Restrictions.eq("sotrudniki.id",Long.valueOf(1)));



        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();

    }




}