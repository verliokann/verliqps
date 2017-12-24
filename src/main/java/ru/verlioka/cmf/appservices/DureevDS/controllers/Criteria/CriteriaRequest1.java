package ru.verlioka.cmf.appservices.DureevDS.controllers.Criteria;

import java.sql.Date;

public class CriteriaRequest1 {

    private String links_name;
    private String links_description;
    private String links_unit;
    private Long links_price;
    private Date aggregation_sale_date;
    private Long aggregation_count;
    private Long aggregation_price;

    public String getLinks_name() {
        return links_name;
    }

    public void setLinks_name(String links_name) {
        this.links_name = links_name;
    }

    public String getLinks_description() {
        return links_description;
    }

    public void setLinks_description(String links_description) {
        this.links_description = links_description;
    }

    public String getLinks_unit() {
        return links_unit;
    }

    public void setLinks_unit(String links_unit) {
        this.links_unit = links_unit;
    }

    public Long getLinks_price() {
        return links_price;
    }

    public void setLinks_price(Long links_price) {
        this.links_price = links_price;
    }

    public Date getAggregation_sale_date() {
        return aggregation_sale_date;
    }

    public void setAggregation_date(Date aggregation_date) {
        this.aggregation_sale_date = aggregation_date;
    }

    public Long getAggregation_count() {
        return aggregation_count;
    }

    public void setAggregation_count(Long aggregation_count) {
        this.aggregation_count = aggregation_count;
    }

    public Long getAggregation_price() {
        return aggregation_price;
    }

    public void setAggregation_price(Long aggregation_price) {
        this.aggregation_price = aggregation_price;
    }
}
