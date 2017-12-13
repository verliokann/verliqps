package ru.verlioka.cmf.appservices.angry.model;

import javax.persistence.*;

@Entity
@Table(name = "commodity")
public class CommodityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "type_id" )
    private CommodityTypeEntity type;

    @Column( name = "name" )
    private String name;

    @Column( name = "description" )
    private String description;

    @Column( name = "unit" )
    private String unit;

    @Column( name = "price" )
    private Long price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CommodityTypeEntity getType() {
        return type;
    }

    public void setType(CommodityTypeEntity type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CommodityEntity{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                '}';
    }
}
