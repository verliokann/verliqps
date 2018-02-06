package ru.verlioka.cmf.appservices.phonecalls.controllers.Criteria;


import org.apache.xpath.operations.String;

import javax.persistence.Column;

public class CriteriaRequest3 {


    private String cityDestination;
    private float callDuration;
    private int callCounts;


    public String getcityDestination() {
        return cityDestination;
    }

    public void setcityDestination(String cityDestination) {
        this.cityDestination = cityDestination;
    }

    public float getcallDuration() {
        return callDuration;
    }

    public void setcallDuration(float callDuration) {
        this.callDuration = callDuration;
    }

    public float getcallCounts() {
        return callCounts;
    }

    public void setCallCounts(int callCounts) {
        this.callCounts = callCounts;
    }
}
