package ru.verlioka.cmf.appservices.presnyakov.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "batch_number" )
    private Long batch_number;

    @Column( name = "cipher" )
    private String cipher;

    @Column( name = "count" )
    private Long count;

    @Column( name = "unit" )
    private String unit;

    @Column( name = "unit_price" )
    private Long unit_price;

    @Column( name = "date_of_receiving" )
    private Date date_of_receiving;

    @Column( name = "provider_id" )
    private Long provider_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", batch_number=" + batch_number +
                ", cipher='" + cipher + '\'' +
                ", count=" + count +
                ", unit='" + unit + '\'' +
                ", unit_price=" + unit_price +
                ", date_of_receiving=" + date_of_receiving +
                ", provider_id=" + provider_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (id != null ? !id.equals(material.id) : material.id != null) return false;
        if (batch_number != null ? !batch_number.equals(material.batch_number) : material.batch_number != null)
            return false;
        if (cipher != null ? !cipher.equals(material.cipher) : material.cipher != null) return false;
        if (count != null ? !count.equals(material.count) : material.count != null) return false;
        if (unit != null ? !unit.equals(material.unit) : material.unit != null) return false;
        if (unit_price != null ? !unit_price.equals(material.unit_price) : material.unit_price != null) return false;
        if (date_of_receiving != null ? !date_of_receiving.equals(material.date_of_receiving) : material.date_of_receiving != null)
            return false;
        return provider_id != null ? provider_id.equals(material.provider_id) : material.provider_id == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (batch_number != null ? batch_number.hashCode() : 0);
        result = 31 * result + (cipher != null ? cipher.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (unit_price != null ? unit_price.hashCode() : 0);
        result = 31 * result + (date_of_receiving != null ? date_of_receiving.hashCode() : 0);
        result = 31 * result + (provider_id != null ? provider_id.hashCode() : 0);
        return result;
    }

    public Long getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(Long batch_number) {
        this.batch_number = batch_number;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Long unit_price) {
        this.unit_price = unit_price;
    }

    public Date getDate_of_receiving() {
        return date_of_receiving;
    }

    public void setDate_of_receiving(Date date_of_receiving) {
        this.date_of_receiving = date_of_receiving;
    }

    public Long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
    }
}
