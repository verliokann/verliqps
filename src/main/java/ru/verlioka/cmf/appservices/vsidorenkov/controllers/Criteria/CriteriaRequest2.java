package ru.verlioka.cmf.appservices.vsidorenkov.controllers.Criteria;

import java.util.Date;

public class CriteriaRequest2 {

    private Date order_date;
    private String client_fio;
    private String client_address;
    private String client_phone;
    private int order_price;
    private int delivery_price;

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getClient_fio() {
        return client_fio;
    }

    public void setClient_fio(String client_fio) {
        this.client_fio = client_fio;
    }

    public String getClient_address() {
        return client_address;
    }

    public void setClient_address(String client_address) {
        this.client_address = client_address;
    }

    public String getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(String client_phone) {
        this.client_phone = client_phone;
    }

    public int getOrder_price() {
        return order_price;
    }

    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }

    public int getDelivery_price() {
        return delivery_price;
    }

    public void setDelivery_price(int delivery_price) {
        this.delivery_price = delivery_price;
    }
}