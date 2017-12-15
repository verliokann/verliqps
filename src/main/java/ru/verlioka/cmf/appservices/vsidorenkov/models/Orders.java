package ru.verlioka.cmf.appservices.vsidorenkov.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table( name = "orders" )
public class Orders {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "clientid" )
    private Clients client;

    @ManyToOne
    @JoinColumn( name = "deliverytypeid" )
    private DeliveryType deliverytype;

    @Column( name = "orderdate" )
    private Date orderdate;

    @Column( name = "orderprice" )
    private int orderprice;

    @Column( name = "deliveryprice" )
    private int deliveryprice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public DeliveryType getDeliverytype() {
        return deliverytype;
    }

    public void setDeliverytype(DeliveryType deliverytype) {
        this.deliverytype = deliverytype;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(int orderprice) {
        this.orderprice = orderprice;
    }

    public int getDeliveryprice() {
        return deliveryprice;
    }

    public void setDeliveryprice(int deliveryprice) {
        this.deliveryprice = deliveryprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (getOrderprice() != orders.getOrderprice()) return false;
        if (getDeliveryprice() != orders.getDeliveryprice()) return false;
        if (getId() != null ? !getId().equals(orders.getId()) : orders.getId() != null) return false;
        if (getClient() != null ? !getClient().equals(orders.getClient()) : orders.getClient() != null) return false;
        if (getDeliverytype() != null ? !getDeliverytype().equals(orders.getDeliverytype()) : orders.getDeliverytype() != null)
            return false;
        return getOrderdate() != null ? getOrderdate().equals(orders.getOrderdate()) : orders.getOrderdate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        result = 31 * result + (getDeliverytype() != null ? getDeliverytype().hashCode() : 0);
        result = 31 * result + (getOrderdate() != null ? getOrderdate().hashCode() : 0);
        result = 31 * result + getOrderprice();
        result = 31 * result + getDeliveryprice();
        return result;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", client=" + client +
                ", deliverytype=" + deliverytype +
                ", orderdate=" + orderdate +
                ", orderprice=" + orderprice +
                ", deliveryprice=" + deliveryprice +
                '}';
    }
}
