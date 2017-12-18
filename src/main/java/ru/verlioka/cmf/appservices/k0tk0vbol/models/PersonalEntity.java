package ru.verlioka.cmf.appservices.k0tk0vbol.models;

import javax.persistence.*;

/**
 * Created by Max on 13.12.2017.
 */
@Entity
@Table(name="emp")
public class PersonalEntity {

    @Id
    @Column(name = "persid")
    private int persid;

    @Column(name ="fio")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "department")
    private DeptEntity department;

    @Column(name = "position")
    private String positon;

    public int getPersid() {
        return persid;
    }

    public void setPersid(int persid) {
        this.persid = persid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public DeptEntity getDepartment() {
        return department;
    }

    public void setDepartment(DeptEntity department) {
        this.department = department;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }
}
