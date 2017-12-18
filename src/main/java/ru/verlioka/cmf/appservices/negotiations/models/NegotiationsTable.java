package ru.verlioka.cmf.appservices.negotiations.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "negotiations_table")
public class NegotiationsTable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_negotiations")
    private Long id;

    @Column(name = "place")
    private String Place;

    @Column(name = "type")
    private String Type;

    @Column(name = "number_of_minutes")
    private Integer NumberOfMinutes;

    @Column(name = "date")
    private Date Date;

    @Column(name = "cost")
    private Integer Cost;

    @Column(name = "name")
    private String Name;

    @Column(name = "tarrif")
    private String Tarrif;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String Name) {
        this.Place = Place;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public Integer getNumberOfMinutes() {
        return NumberOfMinutes;
    }

    public void setNumberOfMinutes(Integer NumberOfMinutes) {
        this.NumberOfMinutes = NumberOfMinutes;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTarrif() {
        return Tarrif;
    }

    public void setTarrif(String Tarrif) {
        this.Tarrif = Tarrif;
    }

    public Integer getCost() {
        return Cost;
    }

    public void setCost(Integer cost) {
        Cost = cost;
    }


}