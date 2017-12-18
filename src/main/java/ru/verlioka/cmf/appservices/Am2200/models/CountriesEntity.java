package ru.verlioka.cmf.appservices.Am2200.models;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class CountriesEntity {
    @Id
    @Column(name = "id_country", unique = true)
    private Integer Id_Country;

    @Column(name = "countryname")
    private String CountryName;

    public Integer getId_Country() {
        return Id_Country;
    }

    public void setId_Country(Integer id_Country) {
        Id_Country = id_Country;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}
