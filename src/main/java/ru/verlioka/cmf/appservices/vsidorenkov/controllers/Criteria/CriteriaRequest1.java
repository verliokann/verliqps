package ru.verlioka.cmf.appservices.vsidorenkov.controllers.Criteria;

public class CriteriaRequest1 {

    private String product_type;
    private String product_name;
    private int stock_product_count;
    private int order_product_count;
    private String client_fio;
    private String delivery_name;

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStock_product_count() {
        return stock_product_count;
    }

    public void setStock_product_count(int stock_product_count) {
        this.stock_product_count = stock_product_count;
    }

    public int getOrder_product_count() {
        return order_product_count;
    }

    public void setOrder_product_count(int order_product_count) {
        this.order_product_count = order_product_count;
    }

    public String getClient_fio() {
        return client_fio;
    }

    public void setClient_fio(String client_fio) {
        this.client_fio = client_fio;
    }

    public String getDelivery_name() {
        return delivery_name;
    }

    public void setDelivery_name(String delivery_name) {
        this.delivery_name = delivery_name;
    }
}