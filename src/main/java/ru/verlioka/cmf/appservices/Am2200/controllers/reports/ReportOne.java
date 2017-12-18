package ru.verlioka.cmf.appservices.Am2200.controllers.reports;

import java.util.Date;

public class ReportOne {
    private String CountryName;
    private String CoastName;
    private Integer AmountOfDays;
    private Date Date_Start;

    public ReportOne(String countryName, String coastName, Integer amountOfDays, Date date_Start) {
        this.CountryName = countryName;
        this.CoastName = coastName;
        this.AmountOfDays = amountOfDays;
        this.Date_Start = date_Start;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getCoastName() {
        return CoastName;
    }

    public void setCoastName(String coastName) {
        CoastName = coastName;
    }

    public Integer getAmountOfDays() {
        return AmountOfDays;
    }

    public void setAmountOfDays(Integer amountOfDays) {
        AmountOfDays = amountOfDays;
    }

    public Date getDate_Start() {
        return Date_Start;
    }

    public void setDate_Start(Date date_Start) {
        Date_Start = date_Start;
    }
}
