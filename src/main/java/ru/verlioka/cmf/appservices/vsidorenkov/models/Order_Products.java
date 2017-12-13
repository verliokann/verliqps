package ru.verlioka.cmf.appservices.vsidorenkov.models;

import javax.persistence.*;

@Entity
@Table( name = "orderproducts" )
public class Order_Products {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @Column( name = "orderid" )
    private int orderid;

    @Column( name = "productstockid" )
    private int productstockid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getProductstockid() {
        return productstockid;
    }

    public void setProductstockid(int productstockid) {
        this.productstockid = productstockid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order_Products that = (Order_Products) o;

        if (getOrderid() != that.getOrderid()) return false;
        if (getProductstockid() != that.getProductstockid()) return false;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getOrderid();
        result = 31 * result + getProductstockid();
        return result;
    }

    @Override
    public String toString() {
        return "Order_Products{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", productstockid=" + productstockid +
                '}';
    }
}
