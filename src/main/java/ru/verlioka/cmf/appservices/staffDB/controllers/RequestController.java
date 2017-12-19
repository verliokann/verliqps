package ru.verlioka.cmf.appservices.staffDB.controllers;

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
import ru.verlioka.cmf.appservices.staffDB.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.staffDB.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.staffDB.models.DepartmentsEntity;
import ru.verlioka.cmf.appservices.staffDB.models.StaffInfoEntity;
import ru.verlioka.cmf.appservices.staffDB.models.TimeSheetEntity;
import ru.verlioka.cmf.appservices.staffDB.services.concrete.DepartmentsService;
import ru.verlioka.cmf.appservices.staffDB.services.concrete.StaffInfoService;
import ru.verlioka.cmf.appservices.staffDB.services.concrete.TimeSheetService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Controller
@EnableTransactionManagement
@RequestMapping("/staffDB")
public class RequestController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DepartmentsService departmentsService;
    @Autowired
    private StaffInfoService staffInfoService;
    @Autowired
    private TimeSheetService timeSheetService;

    private String hql_request_1 = "select \n" +
            "\tstaffinfo.name as StaffInfo_name,\n" +
            "\tstaffinfo.id as StaffInfo_id,\n" +
            "\tstaffinfo.startdate as StartDate,\n" +
            "\tstaffinfo.birthdate as BirthDate,\n" +
            "\tdepartment.departmentname as Department_name,\n" +
            "\tstaffinfo.education as Education,\n" +
            "\tstaffinfo.martialstatus as MartialStatus,\n" +
            "from StaffInfoEntity as staffinfo \n" +
            "inner join staffinfo.department as department";

    private String hql_request_2 = "select \n" +
            "\tworker.id as Worker_id,\n" +
            "\tworker.name as Worker_name,\n" +
            "\ttimesheet.workingdate as WorkingDate,\n" +
            "\t(select timesheet.workinghours from TimeSheetEntity as timesheet where timesheet.workingdate = WorkingDate) as Total_hours\n" +
            "from TimeSheetEntity as timesheet\n" +
            "inner join timesheet.worker as worker";

    @RequestMapping(value = "/departments_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<DepartmentsEntity> getAll_departments() {
        List<DepartmentsEntity> rlist = departmentsService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/staffinfo_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<StaffInfoEntity> getAll_staff() {
        List<StaffInfoEntity> rlist = staffInfoService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/timesheet_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TimeSheetEntity> getAll_timesheets() {
        List<TimeSheetEntity> rlist = timeSheetService.getAll();
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
        Criteria criteria = session.createCriteria(StaffInfoEntity.class,"staffInfo");

        criteria.createAlias("staffInfo.department","department");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("staffinfo.name"),"StaffInfo_name")
                        .add(Projections.property("staffinfo.id"),"StaffInfo_id")
                        .add(Projections.property("staffinfo.startDate"),"StartDate")
                        .add(Projections.property("staffinfo.birthDate"),"BirthDate")
                        .add(Projections.property("department.departmentname"),"Department_name")
                        .add(Projections.property("staffinfo.education"),"Education")
                        .add(Projections.property("staffinfo.martialstatus"),"MartialStatus")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    @RequestMapping(value = "/request_criteria_2", method = RequestMethod.GET)
    public
    @ResponseBody
    List Request2_criteria() {
        Session session = ((Session)entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TimeSheetEntity.class,"timesheet");

        criteria.createAlias("timesheet.worker","worker");
        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("worker.id"),"Worker_id")
                        .add(Projections.property("worker.name"),"Worker_name")
                        .add(Projections.property("timesheet.workingdate"),"WorkingDate")
                        .add(Projections.sqlProjection(
                                "(select timesheet.workinghours from TimeSheetEntity as timesheet where timesheet.workingdate = WorkingDate)  as Total_hours",
                                new String[]{"Total_hours"},
                                new Type[]{new LongType()}),
                                "Total_hours")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }


}
