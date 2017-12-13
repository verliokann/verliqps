package ru.verlioka.cmf.appservices.presnyakov.controllers.Criteria;

import java.sql.Date;

public class GetMaterialsCriteriaRequest {
    private Long batch_number;
    private String cipher;
    private Long count;
    private String unit;
    private Long unit_price;
    private Date date_of_receiving;
    private Long total_price;
    private String name;

    public Long getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(Long batch_number) {
        this.batch_number = batch_number;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Long unit_price) {
        this.unit_price = unit_price;
    }

    public Date getDate_of_receiving() {
        return date_of_receiving;
    }

    public void setDate_of_receiving(Date date_of_receiving) {
        this.date_of_receiving = date_of_receiving;
    }

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
