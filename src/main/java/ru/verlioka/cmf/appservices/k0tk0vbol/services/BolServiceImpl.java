package ru.verlioka.cmf.appservices.k0tk0vbol.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.*;
import org.hibernate.sql.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.DepartInfReq;
import ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.SickInfReq;
import ru.verlioka.cmf.appservices.k0tk0vbol.dao.DepartmentDao;
import ru.verlioka.cmf.appservices.k0tk0vbol.dao.PersonalDao;
import ru.verlioka.cmf.appservices.k0tk0vbol.dao.SickDao;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.DeptEntity;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.PersonalEntity;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.SickEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

import static com.haulmont.yarg.structure.ReportOutputType.doc;


@Service("BolServiceImpl")
public class BolServiceImpl extends GenericServiceImpl<DeptEntity, Integer> implements BolService {

    private static final Logger log = LoggerFactory.getLogger(BolService.class);

    private PersonalDao personalDao;
    private SickDao sickDao;

    @PersistenceContext
    private EntityManager em;

    public BolServiceImpl(){
    }

    @Autowired
    public BolServiceImpl(DepartmentDao dao, PersonalDao personalDao, SickDao sickDao){
        super(dao);
        this.personalDao = personalDao;
        this.sickDao = sickDao;
    }

    public DepartmentDao getdepartmentDao(){
        return (DepartmentDao) getGenericDao();
    }

    public PersonalDao getPersonalDao(){
        return personalDao;
    }

    public SickDao getSickDao(){
        return sickDao;
    }




    @Override
    public List<DepartInfReq> getDepartStaffCriteria() {
        Session session = ((Session)em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(DeptEntity.class, "dept")
                .createCriteria("dept.director", "director", JoinType.INNER_JOIN)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("dept.name"))
                        .add(Projections.property("director.fio"))
                        .add(Projections.property("dept.badnum")));

        return criteria.list();
    }

    @Override
    public List<SickInfReq> getBolStaffCriteria() {
        Session session = ((Session)em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(SickEntity.class, "sicks")
                .createCriteria("sicks.doc", "doc", JoinType.INNER_JOIN)
                .createCriteria("doc.department", "dept", JoinType.INNER_JOIN)
                .setProjection(Projections.projectionList()
                    .add(Projections.property("sicks.fio"))
                    .add(Projections.property("dept.name"))
                    .add(Projections.property("sicks.palata"))
                    .add(Projections.property("sicks.data"))
                    .add(Projections.property("doc.fio"))
                    .add(Projections.property("sicks.diag")));

        return criteria.list();
    }

    @Override
    public List<SickInfReq> getBolstaffHQL() {
        TypedQuery<SickInfReq> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.SickInfReq(sicks.fio, dep.name, sicks.palata, sicks.data, emp.fio, sicks.diag) " +
                        "from SickEntity as sicks " +
                        "INNER JOIN  sicks.doc as emp " +
                        "inner join emp.department as dep",
                SickInfReq.class);
        return typedQuery.getResultList();
    }


    @Override
    public List<DepartInfReq> getDepartStaffHQL() {
        TypedQuery<DepartInfReq> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.DepartInfReq(departments.name, emp.fio, departments.badnum) " +
                "from DeptEntity as departments " +
                "INNER JOIN departments.director as emp", DepartInfReq.class);
        return typedQuery.getResultList();
    }
}
