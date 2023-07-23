package ru.verlioka.cmf.appservices.mudrichenko.controllers;

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
import ru.verlioka.cmf.appservices.mudrichenko.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.mudrichenko.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.mudrichenko.models.CriminalArticlesEntity;
import ru.verlioka.cmf.appservices.mudrichenko.models.CriminalCasesEntity;
import ru.verlioka.cmf.appservices.mudrichenko.models.DefendantsEntity;
import ru.verlioka.cmf.appservices.mudrichenko.models.InvestigatorsEntity;
import ru.verlioka.cmf.appservices.mudrichenko.services.concrete.InvestigatorsService;
import ru.verlioka.cmf.appservices.mudrichenko.services.concrete.DefendantsService;
import ru.verlioka.cmf.appservices.mudrichenko.services.concrete.CriminalCasesEntityService;
import ru.verlioka.cmf.appservices.mudrichenko.services.concrete.CriminalArticlesEntityService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Controller
@EnableTransactionManagement
@RequestMapping("/mudrichenko")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private InvestigatorsService investigatorsService;
    @Autowired
    private DefendantsService defendantsService;
    @Autowired
    private CriminalCasesEntityService criminalCasesService;
    @Autowired
    private CriminalArticlesEntityService criminalArticlesService;


    private String hql_request_1 = "select \n" +
            "\tdefendants.name as defendant_name,\n" +
            "\tdefendants.alias as defendant_alias,\n" +
            "\tcriminal_articles.number as criminal_articles_number,\n" +
            "\tdefendants.birth_date as defendants_birthdate,\n" +
            "\tcriminal_cases.date_of_trial as criminal_cases_date_of_trial,\n" +
            "\tcriminal_articles.description as criminal_articles_description,\n" +
            "\tdefendants.address as defendant_address,\n" +
            "\tdefendants.portrait as defendant_portrait,\n" +
            "\tcriminal_articles.is_uncovered as criminal_article_is_uncovered,\n" +
            "\tinvestigators.name as  investigator_name,\n" +
            "\tdefendants.special_signs as defendant_special_signs,\n" +
            "from CriminalCasesEntity as criminal_cases \n" +
            "inner join criminal_cases.defendants as defendants \n" +
            "inner join criminal_cases.criminal_articles as criminal_articles \n" +
            "inner join criminal_cases.investigators as investigators \n";

    private String hql_request_2 = "select \n" +
            "\tcriminalArticles.number as criminal_articles_number,\n" +
            "\tcriminalCases.entry_date as criminal_cases_entry_date,\n" +
            "\tcriminalArticles.description as criminal_articles_description,\n" +
            "criminalCases.notes as criminal_cases_notes,\n" +
            "inner join criminal_cases.criminal_articles as criminal_articles";


    @RequestMapping(value = "/investigators_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<InvestigatorsEntity> getAll_investigators() {
        List<InvestigatorsEntity> rlist = investigatorsService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/defendants_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<DefendantsEntity> getAll_defendants() {
        List<DefendantsEntity> rlist = defendantsService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/criminal_cases_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CriminalCasesEntity> getAll_criminalCases() {
        List<CriminalCasesEntity> rlist = criminalCasesService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/criminal_articles_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CriminalArticlesEntity> getAll_criminalArticles() {
        List<CriminalArticlesEntity> rlist = criminalArticlesService.getAll();
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
        Criteria criteria = session.createCriteria(CriminalCasesEntity.class,"criminal_cases");

        criteria.createAlias("criminal_cases.defendants","defendants");
        criteria.createAlias("criminal_cases.criminal_articles","criminal_articles");
        criteria.createAlias("criminal_cases.investigators","investigators");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("defendants.name"),"defendant_name")
                        .add(Projections.property("defendants.alias"),"defendant_alias")
                        .add(Projections.property("criminal_articles.number"),"criminal_articles_number")
                        .add(Projections.property("defendants.birth_date"),"defendants_birthdate")
                        .add(Projections.property("criminal_cases.date_of_trial"),"criminal_cases_date_of_trial")
                        .add(Projections.property("criminal_articles.description"),"criminal_articles_description")
                        .add(Projections.property("criminal_articles.is_uncovered"),"criminal_article_is_uncovered")
                        .add(Projections.property("defendants.portrait"),"defendant_portrait")
                        .add(Projections.property("investigators.name"),"investigator_name")
                        .add(Projections.property("defendants.special_signs"),"defendant_special_signs")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CriminalCasesEntity.class,"criminal_cases");

        criteria.createAlias("criminal_cases.criminal_articles","criminal_articles");
        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("criminalArticles.number"),"criminal_articles_number")
                        .add(Projections.property("criminalCases.entry_date"),"criminal_cases_entry_date")
                        .add(Projections.property("criminalArticles.description"),"criminal_articles_description")
                        .add(Projections.property("criminalCases.notes"),"criminal_cases_notes")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }



}
