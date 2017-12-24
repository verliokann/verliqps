package ru.verlioka.cmf.appservices.last_session.model;

import javax.persistence.*;

@Entity
@Table(name = "Element")
public class ElementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "country" )
    private String country;

    @Column( name = "weight" )
    private String weight;

    @Column( name = "price" )
    private String price;

    @Column( name = "nominal" )
    private String nominal;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getweight() {
        return weight;
    }

    public void setweight(String weight) {
        this.weight = weight;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public String getnominal() {
        return nominal;
    }

    public void setnominal(String nominal) {
        this.nominal = nominal;
    }

    @Override
    public String toString() {
        return "ElementEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                ", nominal='" + nominal + '\'' +
                '}';
    }
}
