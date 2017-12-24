package ru.verlioka.cmf.appservices.last_session.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "supply")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "Elements_id" )
    private ElementsEntity Elements;

    @ManyToOne
    @JoinColumn( name = "Element_id" )
    private ElementEntity Element;

    @Column( name = "date" )
    private Date date;

    @Column( name = "count" )
    private Long count;

    @Column( name = "price" )
    private Long price;

    @Column( name = "shipments_are_stopped" )
    private boolean shipments_are_stopped;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElementsEntity getelEments() {
        return Elements;
    }

    public void setElements(ElementsEntity Elements) {
        this.Elements = Elements;
    }

    public ElementEntity getElement() {
        return Element;
    }

    public void setElement(ElementEntity Element) {
        this.Element = Element;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean isShipments_are_stopped() {
        return shipments_are_stopped;
    }

    public void setShipments_are_stopped(boolean shipments_are_stopped) {
        this.shipments_are_stopped = shipments_are_stopped;
    }

    @Override
    public String toString() {
        return "SupplyEntity{" +
                "id=" + id +
                ", Elements=" + Elements +
                ", Element=" + Element +
                ", date=" + date +
                ", count=" + count +
                ", price=" + price +
                ", shipments_are_stopped=" + shipments_are_stopped +
                '}';
    }
}
