package ru.verlioka.cmf.appservices.TextStucture.controllers.Criteria;

import javax.persistence.Column;
import java.sql.Date;

public class CriteriaRequest1 {

    private String type_name;
    private String type_description;

    private String model_name;
    private String model_description;

    public String getType_name() {
        return type_name;
    }

    public String getType_description() {
        return type_description;
    }

    public String getModel_name() {
        return model_name;
    }

    public String getModel_description() {
        return model_description;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public void setModel_description(String model_description) {
        this.model_description = model_description;
    }
}
