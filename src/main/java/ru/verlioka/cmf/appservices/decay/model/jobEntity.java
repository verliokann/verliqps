package ru.verlioka.cmf.appservices.decay.model;

import javax.persistence.*;

@Entity
@Table(name = "job")
public class jobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "Den" )
    private int Den;

    @Column( name = "Mesyac" )
    private int Mesyac;

    @Column( name = "God" )
    private int God;

    @Column( name = "kolichestvo" )
    private int kolichestvo;

    @ManyToOne
    @JoinColumn( name = "people" )
    private peopleEntity people;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDen() {
        return Den;
    }

    public void setDen(int Den) {
        this.Den = Den;
    }

    public int getMesyac() {
        return Mesyac;
    }

    public void setMesyac(int Mesyac) {
        this.Mesyac = Mesyac;
    }

    public int getGod() {
        return God;
    }

    public void setGod(int God) {
        this.God = God;
    }

    public int getKolichestvo() {
        return kolichestvo;
    }

    public void setKolichestvo(int kolichestvo) {
        this.kolichestvo = kolichestvo;
    }

    public peopleEntity getpeople() {
        return people;
    }

    public void setpeople(peopleEntity people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "jobEntity{" +
                "id=" + id +
                ", Den=" + Den +
                ", Mesyac=" + Mesyac +
                ", God=" + God +
                ", kolichestvo=" + kolichestvo +
                ", people=" + people +
                '}';
    }
}