package ru.verlioka.cmf.appservices.staffDB.controllers.Criteria;

import java.sql.Date;

public class CriteriaRequest1 {

    private String staffInfo_name;
    private Long staffInfo_id;
    private Date start_date;
    private Date staffInfo_birthDate;
    private String department_name;
    private String staffInfo_education;
    private String staffInfo_martialStatus;

    public String getStaffInfo_name() {
        return staffInfo_name;
    }

    public void setStaffInfo_name(String staffInfo_name) {
        this.staffInfo_name = staffInfo_name;
    }

    public Long getStaffInfo_Id() {
        return staffInfo_id;
    }

    public void setStaffInfo_Id(Long staffInfo_id) { this.staffInfo_id = staffInfo_id; }

    public Date getStaffInfo_startDate() {
        return start_date;
    }

    public void setStaffInfo_startDate(Date start_date) {
        this.start_date = start_date;
    }

    public Date getStaffInfo_BirthDate() {
        return staffInfo_birthDate;
    }

    public void setStaffInfo_BirthDate(Date staffInfo_birthDate) {
        this.staffInfo_birthDate = staffInfo_birthDate;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getStaffInfo_education() {
        return staffInfo_education;
    }

    public void setStaffInfo_education(String staffInfo_education) {
        this.staffInfo_education = staffInfo_education;
    }

    public String getStaffInfo_martialstatus() {
        return staffInfo_martialStatus;
    }

    public void setStaffInfo_martialstatus(String staffInfo_martialStatus) { this.staffInfo_martialStatus = staffInfo_martialStatus; }
}
