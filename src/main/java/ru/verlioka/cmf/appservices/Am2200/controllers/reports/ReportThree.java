package ru.verlioka.cmf.appservices.Am2200.controllers.reports;


public class ReportThree {
    private String CoastName;
    private int Price;
    private int CountOfVouchers;

    public ReportThree(String coastName, Long price, Long countOfVouchers) {
        this.CoastName = coastName;
        this.Price = Integer.valueOf(price.intValue());
        this.CountOfVouchers = Integer.valueOf(countOfVouchers.intValue());
    }

    public String getCoastName() {
        return CoastName;
    }

    public void setCoastName(String coastName) {
        CoastName = coastName;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getCountOfVouchers() {
        return CountOfVouchers;
    }

    public void setCountOfVouchers(int countOfVouchers) {
        CountOfVouchers = countOfVouchers;
    }
}
