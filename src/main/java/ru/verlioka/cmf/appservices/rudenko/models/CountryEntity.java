package ru.verlioka.cmf.appservices.rudenko.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String name;

    @Column(name = "visa_required", nullable = false)
    private Boolean visaRequired;

    public CountryEntity() {
    }

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

    public Boolean getVisaRequired() {
        return visaRequired;
    }

    public void setVisaRequired(Boolean visaRequired) {
        this.visaRequired = visaRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CountryEntity that = (CountryEntity) o;

        return getId().equals(that.getId()) &&
                getName().equals(that.getName()) &&
                getVisaRequired().equals(that.getVisaRequired());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getVisaRequired().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", visaRequired=" + visaRequired +
                '}';
    }
}
