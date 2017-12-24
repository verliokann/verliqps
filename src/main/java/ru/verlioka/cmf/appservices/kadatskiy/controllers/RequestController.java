package ru.verlioka.cmf.appservices.kadatskiy.controllers;

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
import ru.verlioka.cmf.appservices.angry.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.angry.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.kadatskiy.models.Motherboards;
import ru.verlioka.cmf.appservices.kadatskiy.services.MotherboardsService;
import ru.verlioka.cmf.appservices.kadatskiy.services.ProcessorsService;
import ru.verlioka.cmf.appservices.kadatskiy.services.System_unitsService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Костя on 16.12.2017.
 */

@Controller
@EnableTransactionManagement
@RequestMapping("/kadatskiy")
public class  RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProcessorsService processorsService;
    @Autowired
    private MotherboardsService motherboardsService;
    @Autowired
    private System_unitsService system_unitsService;


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public
    @ResponseBody <Processors> List<Processors> getAllProcessors(){
        List<Processors> processorsList = processorsService.getAll();
        return processorsList;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public
    @ResponseBody <Motherboards> List<Motherboards> getAllMotherboards(){
        List<Motherboards> motherboardsList= motherboardsService.getAll();
        return motherboardsList;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public
    @ResponseBody <System_units> List<System_units> getAllSystem_units(){
        List<System_units> system_unitsList= system_unitsService.getAll();
        return system_unitsList;
    }

    private String hql_request_1 = "select \n" +
            "\tMotherboards.name as motherboards_name,\n" +
            "\tMotherboards.namufacturer as motherboards_namufacturer,\n" +
            "\tProcessors.name as processors_name,\n" +
            "\tProcessors.manufacturer as Processors_manufacturer,\n" +
            "from Motherboards \n" +
            "inner join Motherboards.processor as Processors";

    private String hql_request_2 = "select \n" +
            "\tMotherboards.name as motherboards_name,\n" +
            "\tMotherboards.namufacturer as motherboards_namufacturer,\n" +
            "\tProcessors.name as processors_name,\n" +
            "\tProcessors.manufacturer as Processors_manufacturer,\n" +
            "\tSystem_units.name as System_units_name,\n" +
            "\tSystem_units.manufacturer as System_units_manufacturer,\n" +
            "from System_untis \n" +
            "inner join Motherboards.processor as Processors \n"+
            "inner join System_untis.motherboard as Motherboards ";

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
        Criteria criteria = session.createCriteria(Motherboards.class,"motherboards");

        criteria.createAlias("motherboards.processors","processors");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("motherboards.name"),"motherboards_name")
                        .add(Projections.property("motherboards.manufacturer"),"motherboards_manufacturer")
                        .add(Projections.property("processors.name"),"processors_name")
                        .add(Projections.property("processors.manufacturer"),"processors_manufacturer")

        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Motherboards.class,"motherboards");

        criteria.createAlias("system_units.motherboard","motherboards");
        criteria.createAlias("motherboards.processors","processors");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("motherboards.name"),"motherboards_name")
                        .add(Projections.property("motherboards.manufacturer"),"motherboards_manufacturer")
                        .add(Projections.property("processors.name"),"processors_name")
                        .add(Projections.property("processors.manufacturer"),"processors_manufacturer")
                        .add(Projections.property("system_units.name"),"System_units_name")
                        .add(Projections.property("System_units.manufacturer"),"System_units_manufacturer")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }

}
