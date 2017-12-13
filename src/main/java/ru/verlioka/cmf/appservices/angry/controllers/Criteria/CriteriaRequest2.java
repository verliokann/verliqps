package ru.verlioka.cmf.appservices.angry.controllers.Criteria;

public class CriteriaRequest2 {

    private String type_name;
    private String commodity_name;
    private String commodity_description;
    private Long commodity_count;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

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

    public Long getCommodity_count() {
        return commodity_count;
    }

    public void setCommodity_count(Long commodity_count) {
        this.commodity_count = commodity_count;
    }
}
