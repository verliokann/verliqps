package ru.verlioka.cmf.appservices.phonecalls.controllers.Criteria;



import org.apache.xpath.operations.String;

import javax.persistence.Column;

public class CriteriaRequest1 {

    private String phoneNumber;
    private String cityDestination;
    private Long callLength;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public void setCityDestination(String cityDestination) {
        this.cityDestination = cityDestination;
    }

    public Long getCallLength() {
        return callLength;
    }

    public void setCallLength(Long callLength) {
        this.callLength = callLength;
    }
}
