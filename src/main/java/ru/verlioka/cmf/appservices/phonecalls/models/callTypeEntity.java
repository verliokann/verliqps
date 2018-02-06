package ru.verlioka.cmf.appservices.phonecalls.models;

import javax.persistence.*;


@Entity
@Table(name = "calltype")


public class callTypeEntity {

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "callTypeEntity{" +
                "Id=" + Id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        callTypeEntity that = (callTypeEntity) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return price != null ? price.equals(that.price) : that.price == null;
    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long Id;

    @Column( name = "type" )
    private String type;


    @Column(name = "price")
    private Long price;
}
