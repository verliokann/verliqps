package ru.verlioka.cmf.appservices.vsidorenkov.models;

import javax.persistence.*;

@Entity
@Table( name = "orderproducts" )
public class Order_Products {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "orderid" )
    private Orders order;

    @ManyToOne
    @JoinColumn( name = "productstockid" )
    private ProductStock productstock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public ProductStock getProductstock() {
        return productstock;
    }

    public void setProductstock(ProductStock productstock) {
        this.productstock = productstock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order_Products that = (Order_Products) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getOrder() != null ? !getOrder().equals(that.getOrder()) : that.getOrder() != null) return false;
        return getProductstock() != null ? getProductstock().equals(that.getProductstock()) : that.getProductstock() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getOrder() != null ? getOrder().hashCode() : 0);
        result = 31 * result + (getProductstock() != null ? getProductstock().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order_Products{" +
                "id=" + id +
                ", order=" + order +
                ", productstock=" + productstock +
                '}';
    }
}
