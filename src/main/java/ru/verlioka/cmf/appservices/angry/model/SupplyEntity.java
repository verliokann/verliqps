package ru.verlioka.cmf.appservices.angry.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "supply")
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "commodity_id" )
    private Long commodity_id;

    @Column( name = "provider_id" )
    private Long provider_id;

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

    public Long getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Long commodity_id) {
        this.commodity_id = commodity_id;
    }

    public Long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
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
                ", commodity_id=" + commodity_id +
                ", provider_id=" + provider_id +
                ", date=" + date +
                ", count=" + count +
                ", price=" + price +
                ", shipments_are_stopped=" + shipments_are_stopped +
                '}';
    }
}
