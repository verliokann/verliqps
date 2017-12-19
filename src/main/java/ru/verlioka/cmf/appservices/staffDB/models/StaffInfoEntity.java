package ru.verlioka.cmf.appservices.staffDB.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "staffInfo")
public class StaffInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id" )
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "education")
    private String education;

    @Column(name = "martialStatus")
    private String martialStatus;

    @Column(name = "startDate")
    private Date startDate;

    @ManyToOne
    @Column(name = "departmentId")
    private DepartmentsEntity department;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(String martialStatus) {
        this.martialStatus = martialStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public DepartmentsEntity getDepartmentIdId() {
        return department;
    }

    public void setDepartmentIdId(DepartmentsEntity department) {
        this.department = department;
    }
    @Override
    public String toString() {
        return "StaffInfoEntity{" +
                "id=" + id +
                ", name=" + name +
                ", birthdate=" + birthDate +
                ", education=" + education +
                ", martialStatus=" + martialStatus +
                ", startDate=" + startDate +
                ", department=" + department +
                '}';
    }
}
