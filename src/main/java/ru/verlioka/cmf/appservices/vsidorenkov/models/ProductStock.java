package ru.verlioka.cmf.appservices.vsidorenkov.models;

import javax.persistence.*;

@Entity
@Table( name = "productstock" )
public class ProductStock {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @Column( name = "producttypeid" )
    private int producttypeid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(int producttypeid) {
        this.producttypeid = producttypeid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductStock that = (ProductStock) o;

        if (getProducttypeid() != that.getProducttypeid()) return false;
        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getProducttypeid();
        return result;
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "id=" + id +
                ", producttypeid=" + producttypeid +
                '}';
    }
}
