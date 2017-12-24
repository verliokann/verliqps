package ru.verlioka.cmf.appservices.TextStucture.controllers;

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
import ru.verlioka.cmf.appservices.TextStucture.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.TextStucture.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.TextStucture.Models.type_model;
import ru.verlioka.cmf.appservices.TextStucture.Models.TextType;
import ru.verlioka.cmf.appservices.TextStucture.Models.xModels;
import ru.verlioka.cmf.appservices.TextStucture.services.ModelService;
import ru.verlioka.cmf.appservices.TextStucture.services.TypeModelService;
import ru.verlioka.cmf.appservices.TextStucture.services.TypeService;
import ru.verlioka.cmf.appservices.angry.model.CommodityEntity;
import ru.verlioka.cmf.appservices.angry.model.SupplyEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Controller
@EnableTransactionManagement
@RequestMapping("/TextStructure")
public class RequestController {
    private EntityManager entityManager;

    @Autowired
    private ModelService modelService;

    @Autowired
     private TypeService typeService;

    @Autowired
    private TypeModelService typeModelService;

    private String hql_request_1 = "select \n" +
            "\tTextType.type_name as Type_name,\n" +
            "\tTextType.description as Type_description,\n" +
            "\txModels.modelname as Model_name,\n" +
            "\txModels.description as Model_description";

    private String hql_request_2 = "select '\n" +
            "\txModels.modelname as Model_name,\n" +
            "\tTextType.type_name as Type_name";

    @RequestMapping(value = "/Text_type_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TextType> getAll_texttype() {
        List<TextType> rlist = typeService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/xModel_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<xModels> getALL_model() {
        List<xModels> rlist = modelService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/type_model", method = RequestMethod.GET)
    public
    @ResponseBody
    List<type_model> getALL_typemodel(){
        List<type_model> rlist = typeModelService.getAll();
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

        criteria.createAlias("supply.texttype","texttype");
        criteria.createAlias("supply.model","model");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("texttype.typename"),"type_name")
                        .add(Projections.property("texttype.description"),"type_description")
                        .add(Projections.property("model.name"),"model_name")
                        .add(Projections.property("model.description"),"model_description")
                        .add(Projections.property("supply.date"),"supply_date")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(ru.verlioka.cmf.appservices.angry.controllers.Criteria.CriteriaRequest1.class));
        return criteria.list();
    }
}
