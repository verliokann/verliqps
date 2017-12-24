package ru.verlioka.cmf.appservices.last_session.controllers.Criteria;

public class CriteriaRequest2 {

    private String type_name;
    private String Elements_name;
    private String Elements_description;
    private Long Elements_count;

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getElements_name() {
        return Elements_name;
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

    public Long getElements_count() {
        return Elements_count;
    }

    public void setElements_count(Long Elements_count) {
        this.Elements_count = Elements_count;
    }
}
