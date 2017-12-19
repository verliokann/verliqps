package ru.verlioka.cmf.appservices.staffDB.controllers.Criteria;

import java.sql.Date;

public class CriteriaRequest2 {

    private Long staffInfo_workerId;
    private String staffInfo_workerName;
    private Date timesheet_workingDate;
    private Long timesheet_workingHours;

    public Long getStaffInfo_workerId() {
        return staffInfo_workerId;
    }

    public void setStaffInfo_workerId(Long staffInfo_workerId) { this.staffInfo_workerId = staffInfo_workerId; }

    public String getStaffInfo_workerName() {
        return staffInfo_workerName;
    }

    public void setStaffInfo_workerName(String staffInfo_workerName) { this.staffInfo_workerName = staffInfo_workerName; }

    public Date getTimeSheet_workingDate() {
        return timesheet_workingDate;
    }

    public void setTimeSheet_workingDate(Date timesheet_workingDate) { this.timesheet_workingDate = timesheet_workingDate; }

    public Long getTimeSheet_workingHours() {
        return timesheet_workingHours;
    }

    public void setTimeSheet_workingHours(Long timesheet_workingHours) { this.timesheet_workingHours = timesheet_workingHours; }
}
