package ru.verlioka.cmf.appservices.mudrichenko.models;

import javax.persistence.*;

@Entity
@Table(name = "defendants")
public class DefendantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "alias" )
    private String alias;

    @Column( name = "birth_date" )
    private String birth_date;

    @Column( name = "address" )
    private String address;

    @Column( name = "portrait" )
    private String portrait;

    @Column( name = "special_signs" )
    private String special_signs;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getSpecial_signs() {
        return special_signs;
    }

    public void setSpecial_signs(String special_signs) {
        this.special_signs = special_signs;
    }

    @Override
    public String toString() {
        return "DefendantsEntity{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", alias=" + alias + '\'' +
                ", birth_date=" + birth_date + '\'' +
                ", address=" + address + '\'' +
                ", portrait=" + portrait + '\'' +
                ", special_signs='" + special_signs + '\'' +
                '}';
    }
}
