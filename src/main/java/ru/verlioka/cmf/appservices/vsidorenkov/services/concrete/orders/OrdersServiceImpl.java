package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.orders;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.OrdersDao;
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
            " ( select count(*) from ProductStock where producttypeid = t1.id ) as countstock," +
            " ( select count(*) from Order_Products where orderid = t5.id ) as ordercount," +
            " t2.fio," +
            " t4.name " +
            " from ProductType as t1," +
            " Clients as t2," +
            " ProductStock as t3, " +
            " DeliveryType as t4, " +
            " Orders as t5, " +
            " Order_Products as t6 " +
            " where t5.id = t6.orderid" +
            " and t6.productstockid = t3.id" +
            " and t5.clientid = t2.id" +
            " and t5.deliverytypeid = t4.id" +
            " and t3.producttypeid = t1.id";

    private String request2 = "select \n" +
            " t5.orderdate," +
            " t2.fio," +
            " t2.address," +
            " t2.phone," +
            " t5.orderprice," +
            " t5.deliveryprice" +
            " from Clients as t2," +
            " Orders as t5 " +
            " where t5.clientid = t2.id";

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


}
