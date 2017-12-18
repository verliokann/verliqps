package ru.verlioka.cmf.appservices.Am2200.models;

import javax.persistence.*;

@Entity
@Table(name = "coasts")
public class CoastsEntity {
    @Id
    @Column(name = "id_coast", unique = true)
    private Integer Id_Coast;

    @Column(name = "coastname")
    private String CoastName;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private TypesOfCoastsEntity Id_Type;

    public Integer getId_Coast() {
        return Id_Coast;
    }

    public void setId_Coast(Integer id_Coast) {
        Id_Coast = id_Coast;
    }

    public String getCoastName() {
        return CoastName;
    }

    public void setCoastName(String coastName) {
        CoastName = coastName;
    }

    public TypesOfCoastsEntity getId_Type() {
        return Id_Type;
    }

    public void setId_Type(TypesOfCoastsEntity id_Type) {
        Id_Type = id_Type;
    }
}
