package ru.verlioka.cmf.appservices.k0tk0vbol.models;

import javax.persistence.*;

/**
 * Created by Max on 13.12.2017.
 */
@Entity
@Table(name = "sicks")
public class SickEntity {

    @Id
    @Column(name = "sickid")
    private int sickid;

    @Column(name = "fio")
    private String fio;

    @ManyToOne
    @JoinColumn(name = "doc")
    private PersonalEntity doc;

    @Column(name = "diag")
    private String diag;

   /* @OneToOne
    @JoinColumn(name = "Palata")
    private int Bed;*/
    @Column(name = "palata")
    private int palata;

    @Column(name = "data")
    private String data;

    public int getSickid() {
        return sickid;
    }

    public void setSickid(int sickid) {
        this.sickid = sickid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public PersonalEntity getDoc() {
        return doc;
    }

    public void setDoc(PersonalEntity doc) {
        this.doc = doc;
    }

    public String getDiag() {
        return diag;
    }

    public void setDiag(String diag) {
        this.diag = diag;
    }

    /*public int getPalata() {
        return Bed;
    }

    public void setPalata(int palata) {
        Bed = palata;
    }*/

    public int getPalata() {
        return palata;
    }

    public void setPalata(int palata) {
        this.palata = palata;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
