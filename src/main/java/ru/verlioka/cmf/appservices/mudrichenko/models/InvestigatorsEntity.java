package ru.verlioka.cmf.appservices.mudrichenko.models;

import javax.persistence.*;

@Entity
@Table(name = "investigators")
public class InvestigatorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name" )
    private String name;

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

    @Override
    public String toString() {
        return "InvestigatorsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
