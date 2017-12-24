package ru.verlioka.cmf.appservices.DureevDS.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "aggregation")
public class AggregationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "type_id" )
    private LinksEntity type_id;

    @Column( name = "sale_date" )
    private Date sale_date;

    @Column( name = "count" )
    private Long count;

    @Column( name = "price" )
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LinksEntity getType() {
        return type_id;
    }

    public void setType(LinksEntity type) {
        this.type_id = type_id;
    }

    public Date getSaleDate() {
        return sale_date;
    }

    public void setSaleDate(Date sale_date) {
        this.sale_date = sale_date;
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

    @Override
    public String toString() {
        return "SupplyEntity{" +
                "id=" + id +
                ", type_id=" + type_id +
                ", sale_date=" + sale_date +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
