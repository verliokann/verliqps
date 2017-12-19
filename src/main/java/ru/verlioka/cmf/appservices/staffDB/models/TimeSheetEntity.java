package ru.verlioka.cmf.appservices.staffDB.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timesheet")
public class TimeSheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "sheetid" )
    private Long id;

    @Column( name = "workingdate" )
    private Date workingdate;

    @Column(name = "workinghours")
    private Long workinghours;

    @ManyToOne
    @Column(name = "workerid")
    private StaffInfoEntity worker;

    public Long getSheetId() {
        return id;
    }

    public void setSheetId(Long id) {
        this.id = id;
    }

    public Date getWorkingDate() {
        return workingdate;
    }

    public void setWorkingDate(Date workingdate) {
        this.workingdate = workingdate;
    }

    public Long getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(Long workinghours) {
        this.workinghours = workinghours;
    }

    public StaffInfoEntity getWorkerid() {
        return worker;
    }

    public void setWorkerid(StaffInfoEntity workerid) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "TimeSheetEntity{" +
                "sheetid=" + id +
                ", workingdate=" + workingdate +
                ", workinghours=" + workinghours +
                ", worker=" + worker +
                '}';
    }
}
