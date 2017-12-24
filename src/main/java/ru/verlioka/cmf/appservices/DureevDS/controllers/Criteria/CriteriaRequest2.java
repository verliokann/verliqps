package ru.verlioka.cmf.appservices.DureevDS.controllers.Criteria;

public class CriteriaRequest2 {

    private String aggregation_id;
    private String links_name;
    private String links_manufacturer;
    private Long links_supplier;

    public String getAggregation_id() {
        return aggregation_id;
    }

    public void setAggregation_id(String aggregation_id) {
        this.aggregation_id = aggregation_id;
    }

    public String getLinks_name() {
        return links_name;
    }

    public void setLinks_name(String links_name) {
        this.links_name = links_name;
    }

    public String getLinks_description() {
        return links_manufacturer;
    }

    public void setLinks_manufacturer(String links_manufacturer) {
        this.links_manufacturer = links_manufacturer;
    }

    public Long getLinks_count() {
        return links_supplier;
    }

    public void setLinks_supplier(Long links_supplier) {
        this.links_supplier = links_supplier;
    }
}
