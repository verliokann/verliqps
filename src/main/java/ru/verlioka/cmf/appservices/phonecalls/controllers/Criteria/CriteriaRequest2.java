package ru.verlioka.cmf.appservices.phonecalls.controllers.Criteria;



import javax.persistence.Column;

public class CriteriaRequest2 {

    private String phoneNumber;
    private Long callLength;
    private Long pricePerMinute;

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }

    private Long total_price;


    public Long getPricePerMinute() {
        return pricePerMinute;
    }

    public void setPricePerMinute(Long pricePerMinute) {
        this.pricePerMinute = pricePerMinute;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getCallLength() {
        return callLength;
    }

    public void setCallLength(Long callLength) {
        this.callLength = callLength;
    }
}
