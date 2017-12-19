package ru.verlioka.cmf.appservices.staffDB.models;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class DepartmentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "departmentname" )
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
        return "DepartmentsEntity{" +
                "id=" + id +
                ", departmentname=" + name +
                '}';
    }
}
