package ru.verlioka.cmf.appservices.presnyakov.services.Material;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.presnyakov.controllers.Criteria.GetMaterialsCriteriaRequest;
import ru.verlioka.cmf.appservices.presnyakov.controllers.Criteria.GetMaterialsInfoCriteriaRequest;
import ru.verlioka.cmf.appservices.presnyakov.dao.City.CityDao;
import ru.verlioka.cmf.appservices.presnyakov.dao.Material.MaterialDao;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("materialServiceImpl")
public class MaterialServiceImpl extends GenericServiceImpl<Material, Long>
        implements MaterialService {

    @PersistenceContext
    private EntityManager entityManager;

    public MaterialServiceImpl() {
    }

    private String hql_request_1 = "select \n" +
            "\tmaterial.batch_number,\n" +
            "\tmaterial.cipher,\n" +
            "\tmaterial.count,\n" +
            "\tmaterial.unit,\n" +
            "\tmaterial.unit_price,\n" +
            "\tmaterial.date_of_receiving,\n" +
            "\t(material.count*material.unit_price),\n" +
            "\tprovider.name\n" +
            "from Material as material \n" +
            "inner join material.provider as provider";

    private String hql_request_2 = "select \n" +
            "\tmaterial.cipher,\n" +
            "\tprovider.name,\n" +
            "\tprovider.director,\n" +
            "\tcity.name\n" +
            "from Material as material \n" +
            "inner join material.provider as provider\n" +
            "inner join provider.city as city";

    @Autowired
    public MaterialServiceImpl(MaterialDao genericDao) {
        super(genericDao);
    }

    public List GetMaterialsCriteriaRequest()
    {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Material.class,"material");
        criteria.createAlias("material.provider","provider");
        criteria.createAlias("provider.city","city");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("material.batch_number"),"batch_number")
                        .add(Projections.property("material.cipher"),"cipher")
                        .add(Projections.property("material.count"),"count")
                        .add(Projections.property("material.unit"),"unit")
                        .add(Projections.property("material.unit_price"),"unit_price")
                        .add(Projections.property("material.date_of_receiving"),"date_of_receiving")
                        .add(Projections.property("provider.name"),"name")
                        .add(Projections.sqlProjection(
                                "(this_.count*this_.unit_price) as total_price",
                                new String[]{"total_price"},
                                new Type[]{new LongType()}),
                                "total_price")

        );

        criteria.setResultTransformer(Transformers.aliasToBean(GetMaterialsCriteriaRequest.class));
        return criteria.list();
    }

    public List GetMaterialInfoCriteriaRequest()
    {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Material.class,"material");
        criteria.createAlias("material.provider","provider");
        criteria.createAlias("provider.city","city");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("material.cipher"),"cipher")
                        .add(Projections.property("provider.name"),"name")
                        .add(Projections.property("provider.director"),"director")
                        .add(Projections.property("city.name"),"city_name")

        );

        criteria.setResultTransformer(Transformers.aliasToBean(GetMaterialsInfoCriteriaRequest.class));
        return criteria.list();
    }

    public List GetMaterialInfoRequest()
    {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(hql_request_2);
        return query.list();
    }

    public List GetMaterialsRequest()
    {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(hql_request_1);
        return query.list();
    }


}
