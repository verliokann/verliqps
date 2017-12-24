package ru.verlioka.cmf.appservices.last_session.controllers.Criteria;

import java.sql.Date;

public class CriteriaRequest1 {

    private String Elements_name;
    private String Elements_description;
    private String Elements_unit;
    private Long Elements_price;
    private String Element_name;
    private String Element_country;
    private String Element_weight;
    private String Element_price;
    private String Element_nominal;
    private Date supply_date;
    private Long supply_count;
    private Long supply_price;
    private boolean supply_shipments_are_stopped;


    public String getElements_name() { return Elements_name;
    }

    public void setElements_name(String Elements_name) {
        this.Elements_name = Elements_name;
    }

    public String getElements_description() {
        return Elements_description;
    }

    public void setElements_description(String Elements_description) {
        this.Elements_description = Elements_description;
    }

    public String getElements_unit() {
        return Elements_unit;
    }

    public void setElements_unit(String Elements_unit) {
        this.Elements_unit = Elements_unit;
    }

    public Long getElements_price() {
        return Elements_price;
    }

    public void setElements_price(Long Elements_price) {
        this.Elements_price = Elements_price;
    }

    public String getElement_name() {
        return Element_name;
    }

    public void setElement_name(String Element_name) {
        this.Element_name = Element_name;
    }

    public String getElement_country() {
        return Element_country;
    }

    public void setElement_country(String Element_country) {
        this.Element_country = Element_country;
    }

    public String getElement_weight() {
        return Element_weight;
    }

    public void setElement_weight(String Element_weight) {
        this.Element_weight = Element_weight;
    }

    public String getElement_price() {
        return Element_price;
    }

    public void setElement_price(String Element_price) {
        this.Element_price = Element_price;
    }

    public String getElement_nominal() {
        return Element_nominal;
    }

    public void setElement_nominal(String Element_nominal) {
        this.Element_nominal= Element_nominal;
    }

    public Date getSupply_date() {
        return supply_date;
    }

    public void setSupply_date(Date supply_date) {
        this.supply_date = supply_date;
    }

    public Long getSupply_count() {
        return supply_count;
    }

    public void setSupply_count(Long supply_count) {
        this.supply_count = supply_count;
    }

    public Long getSupply_price() {
        return supply_price;
    }

    public void setSupply_price(Long supply_price) {
        this.supply_price = supply_price;
    }

    public boolean isSupply_shipments_are_stopped() {
        return supply_shipments_are_stopped;
    }

    public void setSupply_shipments_are_stopped(boolean supply_shipments_are_stopped) {
        this.supply_shipments_are_stopped = supply_shipments_are_stopped;
    }
}
