package ru.verlioka.cmf.appservices.angry.controllers.Criteria;

import javax.persistence.Column;
import java.sql.Date;

public class CriteriaRequest1 {

    private String commodity_name;
    private String commodity_description;
    private String commodity_unit;
    private Long commodity_price;
    private String provider_name;
    private String provider_country;
    private String provider_city;
    private String provider_phone;
    private String provider_fax;
    private Date supply_date;
    private Long supply_count;
    private Long supply_price;
    private boolean supply_shipments_are_stopped;

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_description() {
        return commodity_description;
    }

    public void setCommodity_description(String commodity_description) {
        this.commodity_description = commodity_description;
    }

    public String getCommodity_unit() {
        return commodity_unit;
    }

    public void setCommodity_unit(String commodity_unit) {
        this.commodity_unit = commodity_unit;
    }

    public Long getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(Long commodity_price) {
        this.commodity_price = commodity_price;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_country() {
        return provider_country;
    }

    public void setProvider_country(String provider_country) {
        this.provider_country = provider_country;
    }

    public String getProvider_city() {
        return provider_city;
    }

    public void setProvider_city(String provider_city) {
        this.provider_city = provider_city;
    }

    public String getProvider_phone() {
        return provider_phone;
    }

    public void setProvider_phone(String provider_phone) {
        this.provider_phone = provider_phone;
    }

    public String getProvider_fax() {
        return provider_fax;
    }

    public void setProvider_fax(String provider_fax) {
        this.provider_fax = provider_fax;
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
