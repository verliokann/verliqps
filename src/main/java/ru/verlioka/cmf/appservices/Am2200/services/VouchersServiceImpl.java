package ru.verlioka.cmf.appservices.Am2200.services;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportOne;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportThree;
import ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportTwo;
import ru.verlioka.cmf.appservices.Am2200.dao.*;
import ru.verlioka.cmf.appservices.Am2200.models.VouchersEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("vouchersServiceImpl")
public class VouchersServiceImpl extends GenericServiceImpl<VouchersEntity, Integer> implements VouchersService{

    private CoastsDao coastsDao;
    private CountriesDao countriesDao;
    private HotelsDao hotelsDao;
    private TypesOfCoastsDao typesOfCoastsDao;
    private VouchersDao vouchersDao;

    @PersistenceContext
    private EntityManager em;

    public VouchersServiceImpl() {

    }

    @Autowired
    public VouchersServiceImpl(CoastsDao coastsDao, CountriesDao countriesDao, HotelsDao hotelsDao, TypesOfCoastsDao typesOfCoastsDao, VouchersDao vouchersDao) {
        super(vouchersDao);
        this.coastsDao = coastsDao;
        this.countriesDao = countriesDao;
        this.hotelsDao = hotelsDao;
        this.typesOfCoastsDao = typesOfCoastsDao;
    }

    @Override
    public List<ReportOne> getReportOneCriteria() {
        Session session = ((Session)em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(VouchersEntity.class, "vouchers")
                .add(Restrictions.ge("vouchers.AmountOfDays", 10))
                .add(Restrictions.le("vouchers.AmountOfDays", 15))
                .add(Restrictions.ne("vouchers.Id_Voucher", 0))
                .addOrder(Order.desc("AmountOfDays"))
                .createCriteria("vouchers.Country", "country", JoinType.INNER_JOIN)
                .createCriteria("vouchers.Coast", "coast", JoinType.INNER_JOIN)
                .setProjection(Projections.projectionList()
                .add(Projections.property("country.CountryName"))
                .add(Projections.property("coast.CoastName"))
                .add(Projections.property("vouchers.AmountOfDays"))
                .add(Projections.property("vouchers.Start_Date")));
        return criteria.list();
    }

    @Override
    public List<ReportOne> getReportOneHQL() {
        TypedQuery<ReportOne> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportOne(country.CountryName, coast.CoastName, voucher.AmountOfDays, voucher.Start_Date)" +
                " from VouchersEntity as voucher " +
                " INNER JOIN voucher.Country as country" +
                " INNER JOIN voucher.Coast as coast" +
                " WHERE voucher.AmountOfDays >= 10 AND voucher.AmountOfDays <= 15 AND voucher.Id_Voucher <> 0 " +
                " ORDER BY voucher.AmountOfDays", ReportOne.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<ReportTwo> getReportTwoCriteria() {
        Session session = ((Session)em.getDelegate()).getSessionFactory().openSession();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(VouchersEntity.class, "voucher");
        detachedCriteria.setProjection(
                Projections.projectionList()
                .add(Projections.sum("voucher.Price").as("TotalPrice"))
        );
        Criteria criteria = session.createCriteria(VouchersEntity.class, "vouchers")
                .add(Restrictions.isNotNull("IsVisaNeed"))
                .add(Restrictions.ne("vouchers.Id_Voucher", 0))
                .createCriteria("vouchers.Country", "country", JoinType.INNER_JOIN)
                .createCriteria("vouchers.Id_Hotel", "hotel", JoinType.INNER_JOIN)
                .createCriteria("vouchers.Coast", "coast", JoinType.INNER_JOIN)
                .setProjection(Projections.projectionList()
                .add(Projections.property("country.CountryName"))
                .add(Projections.property("hotel.HotelName"))
                .add(Projections.property("coast.CoastName"))
                .add(Projections.property("vouchers.Start_Date"))
                .add(Projections.property("vouchers.End_Date"))
                .add(Projections.property("vouchers.Price"))
                .add(Projections.sum("vouchers.Price"))); //Subqueries.propertyIn("TotalPrice", detachedCriteria)
//                .add(Subqueries.exists(detachedCriteria));
        return criteria.list();
    }

    @Override
    public List<ReportTwo> getReportTwoHQL() {
        TypedQuery<ReportTwo> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportTwo(country.CountryName, hotel.HotelName, coast.CoastName, voucher.Start_Date, voucher.End_Date, voucher.Price, " +
                " (select sum(voucher.Price) from VouchersEntity as voucher))" +
                " from VouchersEntity as voucher " +
                " INNER JOIN voucher.Country as country " +
                " INNER JOIN voucher.Id_Hotel as hotel " +
                " INNER JOIN voucher.Coast as coast " +
                " WHERE voucher.IsVisaNeed IS NOT NULL AND voucher.Id_Voucher <> 0 " +
                " ORDER BY hotel.HotelName", ReportTwo.class);
        return typedQuery.getResultList();
    }

    @Override
    public List<ReportThree> getReportThreeCriteria() {
        Session session = ((Session)em.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(VouchersEntity.class, "vouchers")
                .add(Restrictions.ne("vouchers.Id_Voucher", 0))
                .createCriteria("vouchers.Coast", "coast", JoinType.INNER_JOIN)
                .createCriteria("coast.Id_Type", "coastType", JoinType.INNER_JOIN)
                .setProjection(Projections.projectionList()
                        .add(Projections.property("coastType.TypeName"))
                        .add(Projections.sum("vouchers.Price"))
                        .add(Projections.count("vouchers.Id_Voucher"))
                        .add(Projections.groupProperty("coastType.TypeName"))
                );
        return criteria.list();
    }

    @Override
    public List<ReportThree> getReportThreeHQL() {
        TypedQuery<ReportThree> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.Am2200.controllers.reports.ReportThree(coastType.TypeName, sum(voucher.Price), count(voucher.Id_Voucher)) " +
                " from VouchersEntity as voucher " +
                " INNER JOIN voucher.Coast as coast " +
                " INNER JOIN coast.Id_Type as coastType " +
                " WHERE coastType.Id_Type <> 0 " +
                " GROUP BY coastType.TypeName", ReportThree.class);
        return typedQuery.getResultList();
    }
}
