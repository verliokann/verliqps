package ru.verlioka.cmf.appservices.vsidorenkov.models;

import javax.persistence.*;

@Entity
@Table( name = "productstock" )
public class ProductStock {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id" )
    private Long id;

    @ManyToOne
    @JoinColumn( name = "producttypeid" )
    private ProductType producttype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductStock that = (ProductStock) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getProducttype() != null ? getProducttype().equals(that.getProducttype()) : that.getProducttype() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getProducttype() != null ? getProducttype().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductStock{" +
                "id=" + id +
                ", producttype=" + producttype +
                '}';
    }
}
