package ru.verlioka.cmf.appservices.Am2200.models;

import javax.persistence.*;

@Entity
@Table(name = "typesofcoasts")
public class TypesOfCoastsEntity {
    @Id
    @Column(name = "id_type", unique = true)
    private Integer Id_Type;

    @Column(name = "typename")
    private String TypeName;

    public Integer getId_Type() {
        return Id_Type;
    }

    public void setId_Type(Integer id_Type) {
        Id_Type = id_Type;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String typeName) {
        TypeName = typeName;
    }
}
