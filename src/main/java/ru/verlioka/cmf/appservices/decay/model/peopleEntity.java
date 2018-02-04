package ru.verlioka.cmf.appservices.decay.model;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class peopleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column( name = "FIO" )
    private char FIO;

    @Column( name = "Oklad" )
    private int Oklad;

    @Column( name = "Dolzhnost" )
    private char Dolzhnost;

    @Column( name = "Obrazovanie" )
    private char Obrazovanie;

    @Column( name = "zarp_chas" )
    private int zarp_chas;

    @ManyToOne
    @JoinColumn( name = "job" )
    private jobEntity job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public char getFIO() {
        return FIO;
    }

    public void setFIO(char FIO) {
        this.FIO = FIO;
    }

    public int getOklad() {
        return Oklad;
    }

    public void setOklad(char Oklad) {
        this.Oklad = Oklad;
    }

    public char getDolzhnost() {
        return Dolzhnost;
    }

    public void setDolzhnost(char Dolzhnost) {
        this.Dolzhnost = Dolzhnost;
    }

    public char getObrazovanie() {
        return Obrazovanie;
    }

    public void setObrazovanie(char Obrazovanie) {
        this.Obrazovanie = Obrazovanie;
    }

    public int getzarp_chas() {
        return zarp_chas;
    }

    public void setzarp_chas(char zarp_chas) {
        this.zarp_chas = zarp_chas;
    }

    public jobEntity getjob() {
        return job;
    }

    public void setjob(jobEntity job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "peopleTypeEntity{" +
                "id=" + id +
                ", FIO='" + FIO + ", Oklad=" + Oklad +", Dolzhnost="
                + Dolzhnost +", Obrazovanie=" + Obrazovanie +", zarp_chas=" + zarp_chas + "job = " + job  +
                '}';
    }
}
