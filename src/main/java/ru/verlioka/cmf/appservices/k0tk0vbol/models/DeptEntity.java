package ru.verlioka.cmf.appservices.k0tk0vbol.models;

import javax.persistence.*;

/**
 * Created by Max on 13.12.2017.
 */
@Entity
@Table(name = "depart")
public class DeptEntity {

    @Id
    @Column(name = "depid", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "director")
    private PersonalEntity director;

    @Column(name = "badnum")
    private int badnum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadnum() {
        return badnum;
    }

    public void setBadnum(int badnum) {
        this.badnum = badnum;
    }

    public PersonalEntity getDirector() {
        return director;
    }

    public void setDirector(PersonalEntity director) {
        this.director = director;
    }

}