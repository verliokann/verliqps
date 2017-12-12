package ru.verlioka.cmf.appservices.angry.model;

import javax.persistence.*;

@Entity
@Table(name = "commodity_type")
public class CommodityTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name" )
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommodityTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
