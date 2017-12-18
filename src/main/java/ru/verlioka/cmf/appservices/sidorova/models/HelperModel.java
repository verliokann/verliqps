package ru.verlioka.cmf.appservices.sidorova.models;

public class HelperModel {
    private Integer nominalPriceStock;
    private String typeStock;
    private Integer percentAccrual;
    private Float sellingPrice;
    private Integer totalPurchasePrice;
    private Float totalSellingPrice;

    public HelperModel() {
    }

    public HelperModel(Integer nominalPriceStock, String typeStock, Integer percentAccrual, Float sellingPrice, Integer totalPurchasePrice, Float totalSellingPrice) {
        this.nominalPriceStock = nominalPriceStock;
        this.typeStock = typeStock;
        this.percentAccrual = percentAccrual;
        this.sellingPrice = sellingPrice;
        this.totalPurchasePrice = totalPurchasePrice;
        this.totalSellingPrice = totalSellingPrice;
    }

    public Integer getNominalPriceStock() {
        return nominalPriceStock;
    }

    public void setNominalPriceStock(Integer nominalPriceStock) {
        this.nominalPriceStock = nominalPriceStock;
    }

    public String getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(String typeStock) {
        this.typeStock = typeStock;
    }

    public Integer getPercentAccrual() {
        return percentAccrual;
    }

    public void setPercentAccrual(Integer percentAccrual) {
        this.percentAccrual = percentAccrual;
    }

    public Float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public void setTotalPurchasePrice(Integer totalPurchasePrice) {
        this.totalPurchasePrice = totalPurchasePrice;
    }

    public Float getTotalSellingPrice() {
        return totalSellingPrice;
    }

    public void setTotalSellingPrice(Float totalSellingPrice) {
        this.totalSellingPrice = totalSellingPrice;
    }
}
