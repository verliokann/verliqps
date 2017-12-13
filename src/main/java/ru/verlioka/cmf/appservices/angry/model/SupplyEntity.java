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

    @ManyToOne
    @JoinColumn( name = "commodity_id" )
    private CommodityEntity commodity;

    @ManyToOne
    @JoinColumn( name = "provider_id" )
    private ProvidersEntity provider;

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

    public CommodityEntity getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityEntity commodity) {
        this.commodity = commodity;
    }

    public ProvidersEntity getProvider() {
        return provider;
    }

    public void setProvider(ProvidersEntity provider) {
        this.provider = provider;
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
                ", commodity=" + commodity +
                ", provider=" + provider +
                ", date=" + date +
                ", count=" + count +
                ", price=" + price +
                ", shipments_are_stopped=" + shipments_are_stopped +
                '}';
    }
}
