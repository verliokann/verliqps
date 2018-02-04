package ru.verlioka.cmf.appservices.decay.controllers;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.decay.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.decay.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.decay.model.jobEntity;
import ru.verlioka.cmf.appservices.decay.model.peopleEntity;
import ru.verlioka.cmf.appservices.decay.services.concrete.jobService;
import ru.verlioka.cmf.appservices.decay.services.concrete.peopleService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@EnableTransactionManagement
@RequestMapping("/decay")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private jobService jobService;
    @Autowired
    private peopleService peopleService;


    private String hql_request_1 = "select \n" +
            "\tjob.Den as job_Den,\n" +
            "\tjob.Mesyac as job_Mesyac,\n" +
            "\tjob.God as job_God,\n" +
            "\tjob.kolichestvo as job_kolichestvo,\n" +
            "\tpeople.FIO as people_FIO,\n" +
            "\tpeople.Oklad as people_Oklad,\n" +
            "\tpeople.Dolzhnost as people_Dolzhnost,\n" +
            "\tpeople.Obrazovanie as people_Obrazovanie,\n" +
            "\tpeople.zarp_chas as people_zarp_chas,\n" +
            "from jobEntity as job \n" +
            "inner join job.people as people \n" ;

    private String hql_request_2 = "select \n" +
            "\tpeople.FIO as people_FIO,\n" +
            "\tpeople.Oklad as people_Oklad,\n" +
            "\tpeople.zarp_chas as people_zarp_chas,\n" +
            "\tjob.kolichestvo as job_kolichestvo,\n" +
            "from peopleEntity as people\n"+
            "inner join people.jobEntity as job";

    @RequestMapping(value = "/job_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<jobEntity> getAll_job() {
        List<jobEntity> rlist = jobService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/people_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<peopleEntity> getAll_type() {
        List<peopleEntity> rlist = peopleService.getAll();
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
        Criteria criteria = session.createCriteria(peopleEntity.class,"people");

        criteria.createAlias("people.job","job");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("job.Den"),"job_Den")
                        .add(Projections.property("job.Mesyac"),"job_Mesyac")
                        .add(Projections.property("job.God"),"job_God")
                        .add(Projections.property("job.kolichestvo"),"job_kolichestvo")
                        .add(Projections.property("job.people"),"job_people")
                        .add(Projections.property("people.FIO"),"people_FIO")
                        .add(Projections.property("people.Oklad"),"people_Oklad")
                        .add(Projections.property("people.Dolzhnost"),"people_Dolzhnost")
                        .add(Projections.property("people.Obrazovanie"),"people_Obrazovanie")
                        .add(Projections.property("people.zarp_chas"),"people_zarp_chas")
                        .add(Projections.property("people.job"),"people_job")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(jobEntity.class,"job");

        criteria.createAlias("job.people","people");
        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("people.FIO"),"people_FIO")
                        .add(Projections.property("people.Oklad"),"people_Oklad")
                        .add(Projections.property("people.zarp_chas"),"people_zarp_chas")
                        .add(Projections.property("job.kolichestvo"),"job_kolichestvo")

        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }


}
