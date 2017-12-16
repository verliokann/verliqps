package ru.verlioka.cmf.appservices.sidorova.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "papers")
public class PaperModel {

    @Column (name = "number_company")
    private Integer numberCompany;

    @Id
    @Column (name = "number_stock")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer numberStock;

    @Column (name = "type_stock")
    private String typeStock;

    @Column (name = "count_stock")
    private Integer countStock;

    @Column (name = "nominal_price_stock")
    private Integer nominalPriceStock;

    @Column (name = "date_edition")
    private Date dateEdition;

    @Column (name = "percent_accrual")
    private Integer percentAccrual;

    @Column (name = "time_repayment")
    private Date timeRepayment;

    @Column (name = "exchange_value")
    private Integer exchangeValue;

    @Column (name = "purchase_price")
    private Integer purchasePrice;

    public PaperModel() {
    }

    public PaperModel(Integer numberCompany, String typeStock, Integer countStock, Integer nominalPriceStock, Date dateEdition, Integer percentAccrual, Date timeRepayment, Integer exchangeValue, Integer purchasePrice) {
        this.numberCompany = numberCompany;
        this.typeStock = typeStock;
        this.countStock = countStock;
        this.nominalPriceStock = nominalPriceStock;
        this.dateEdition = dateEdition;
        this.percentAccrual = percentAccrual;
        this.timeRepayment = timeRepayment;
        this.exchangeValue = exchangeValue;
        this.purchasePrice = purchasePrice;
    }

    public Integer getNumberCompany() {
        return numberCompany;
    }

    public void setNumberCompany(Integer numberCompany) {
        this.numberCompany = numberCompany;
    }

    public Integer getNumberStock() {
        return numberStock;
    }

    public void setNumberStock(Integer numberStock) {
        this.numberStock = numberStock;
    }

    public String getTypeStock() {
        return typeStock;
    }

    public void setTypeStock(String typeStock) {
        this.typeStock = typeStock;
    }

    public Integer getCountStock() {
        return countStock;
    }

    public void setCountStock(Integer countStock) {
        this.countStock = countStock;
    }

    public Integer getNominalPriceStock() {
        return nominalPriceStock;
    }

    public void setNominalPriceStock(Integer nominalPriceStock) {
        this.nominalPriceStock = nominalPriceStock;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Integer getPercentAccrual() {
        return percentAccrual;
    }

    public void setPercentAccrual(Integer percentAccrual) {
        this.percentAccrual = percentAccrual;
    }

    public Date getTimeRepayment() {
        return timeRepayment;
    }

    public void setTimeRepayment(Date timeRepayment) {
        this.timeRepayment = timeRepayment;
    }

    public Integer getExchangeValue() {
        return exchangeValue;
    }

    public void setExchangeValue(Integer exchangeValue) {
        this.exchangeValue = exchangeValue;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Integer purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
}

