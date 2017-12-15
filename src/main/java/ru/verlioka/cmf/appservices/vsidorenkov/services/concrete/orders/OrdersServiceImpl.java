package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.orders;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.controllers.Criteria.CriteriaRequest1;
import ru.verlioka.cmf.appservices.vsidorenkov.controllers.Criteria.CriteriaRequest2;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.OrdersDao;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Order_Products;
import ru.verlioka.cmf.appservices.vsidorenkov.models.Orders;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("OrdersServiceImpl")
public class OrdersServiceImpl extends GenericServiceImpl<Orders, Long>
        implements OrdersService {

    @PersistenceContext
    private EntityManager entityManager;

    public OrdersServiceImpl() {
    }

    private String request1 = "select \n" +
            " t1.name," +
            " t1.type," +
            " ( select count(*) from ProductStock where producttype = t1.id ) as countstock," +
            " ( select count(*) from Order_Products where order = t5.id ) as ordercount," +
            " t2.fio," +
            " t4.name " +
            " from ProductType as t1," +
            " Clients as t2," +
            " ProductStock as t3, " +
            " DeliveryType as t4, " +
            " Orders as t5, " +
            " Order_Products as t6 " +
            " where t6.order = t5" +
            " and t6.productstock = t3" +
            " and t5.client = t2" +
            " and t5.deliverytype = t4" +
            " and t3.producttype = t1";

    private String request2 = "select \n" +
            " t5.orderdate," +
            " t2.fio," +
            " t2.address," +
            " t2.phone," +
            " t5.orderprice," +
            " t5.deliveryprice" +
            " from Clients as t2," +
            " Orders as t5 " +
            " where t5.client = t2";

    @Autowired
    public OrdersServiceImpl(OrdersDao genericDao) {
        super(genericDao);
    }

    public List GetRequest1() {
        Session session = ((Session) entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(request1);
        return query.list();
    }

    public List GetRequest2() {
        Session session = ((Session) entityManager.getDelegate()).getSessionFactory().openSession();
        Query query = session.createQuery(request2);
        return query.list();
    }

    public List GetCriteriaRequest1() {
        Session session = ((Session) entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Order_Products.class, "order_products");

        criteria.createAlias("order_products.order", "order");
        criteria.createAlias("order_products.productstock", "productstock");
        criteria.createAlias("order.deliverytype", "deliverytype");
        criteria.createAlias("order.client", "client");
        criteria.createAlias("productstock.producttype", "producttype");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("producttype.type"), "product_type")
                        .add(Projections.property("producttype.name"), "product_name")
                        .add(Projections.sqlProjection(
                                "( select count(*) from ProductStock as t1, ProductType as t2, Orders as t3 where t1.id = this_.productstockid and t1.producttypeid = t2.id and t3.id = this_.orderid ) as stock_product_count",
                                new String[]{"stock_product_count"},
                                new Type[]{new IntegerType()}),
                                "stock_product_count")
                        .add(Projections.sqlProjection(
                                "( select count(*) from Orders as t1 where t1.id = this_.orderid ) as order_product_count",
                                new String[]{"order_product_count"},
                                new Type[]{new IntegerType()}),
                                "order_product_count")
                        .add(Projections.property("client.fio"), "client_fio")
                        .add(Projections.property("deliverytype.name"), "delivery_name")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest1.class));
        return criteria.list();
    }

    public List GetCriteriaRequest2() {

        Session session = ((Session) entityManager.getDelegate()).getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Orders.class, "order");

        criteria.createAlias("order.client", "client");

        criteria.setProjection(
                Projections.projectionList()
                        .add(Projections.property("order.orderdate"), "order_date")
                        .add(Projections.property("client.fio"), "client_fio")
                        .add(Projections.property("client.address"), "client_address")
                        .add(Projections.property("client.phone"), "client_phone")
                        .add(Projections.property("order.orderprice"), "order_price")
                        .add(Projections.property("order.deliveryprice"), "delivery_price")
        );

        criteria.setResultTransformer(Transformers.aliasToBean(CriteriaRequest2.class));
        return criteria.list();
    }
}
