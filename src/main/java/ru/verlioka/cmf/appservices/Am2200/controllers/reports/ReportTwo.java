package ru.verlioka.cmf.appservices.Am2200.controllers.reports;

import org.apache.batik.anim.timing.Interval;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class ReportTwo {
    private String CountryName;
    private String HotelName;
    private String CoastName;
    private Integer Price;
    private String Date_Start;
    private String Date_End;

    private int DifferenceBetweenDates;
    private int TotalPriceForCurrentVoucher;
    private int TotalPriceVouchers;
    private int TotalPriceWithSale;

    public ReportTwo(String countryName, String hotelName, String coastName, Date date_Start, Date date_End, Integer price, Long totalPrice) {
        this.CountryName = countryName;
        this.HotelName = hotelName;
        this.CoastName = coastName;
        this.Date_Start = date_Start.toString();
        this.Date_End = date_End.toString();
        this.DifferenceBetweenDates = (int)( (date_End.getTime() - date_Start.getTime()) / 1000 * 60 * 60 * 24);
        this.TotalPriceForCurrentVoucher = Calculate(price);
        this.TotalPriceWithSale = Integer.valueOf(totalPrice.intValue());
        this.TotalPriceVouchers = Calculate(totalPrice);
        this.Price = price;
    }

    private int Calculate(Integer oldPrice) {
        int TenPercent = (10 * oldPrice) / 100;
        return oldPrice + TenPercent;
    }

    private int Calculate(Long oldPrice) {
        Integer tmp = Integer.valueOf(oldPrice.intValue());
        int TenPercent = (10 * tmp) / 100;
        return tmp + TenPercent;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getCoastName() {
        return CoastName;
    }

    public void setCoastName(String coastName) {
        CoastName = coastName;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getDate_Start() {
        return Date_Start;
    }

    public void setDate_Start(String date_Start) {
        Date_Start = date_Start;
    }

    public String getDate_End() {
        return Date_End;
    }

    public void setDate_End(String date_End) {
        Date_End = date_End;
    }

    public int getDifferenceBetweenDates() {
        return DifferenceBetweenDates;
    }

    public void setDifferenceBetweenDates(int differenceBetweenDates) {
        DifferenceBetweenDates = differenceBetweenDates;
    }

    public int getTotalPriceForCurrentVoucher() {
        return TotalPriceForCurrentVoucher;
    }

    public void setTotalPriceForCurrentVoucher(int totalPriceForCurrentVoucher) {
        TotalPriceForCurrentVoucher = totalPriceForCurrentVoucher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportTwo reportTwo = (ReportTwo) o;

        if (DifferenceBetweenDates != reportTwo.DifferenceBetweenDates) return false;
        if (TotalPriceForCurrentVoucher != reportTwo.TotalPriceForCurrentVoucher) return false;
        if (CountryName != null ? !CountryName.equals(reportTwo.CountryName) : reportTwo.CountryName != null)
            return false;
        if (HotelName != null ? !HotelName.equals(reportTwo.HotelName) : reportTwo.HotelName != null) return false;
        if (CoastName != null ? !CoastName.equals(reportTwo.CoastName) : reportTwo.CoastName != null) return false;
        if (Price != null ? !Price.equals(reportTwo.Price) : reportTwo.Price != null) return false;
        if (Date_Start != null ? !Date_Start.equals(reportTwo.Date_Start) : reportTwo.Date_Start != null) return false;
        return Date_End != null ? Date_End.equals(reportTwo.Date_End) : reportTwo.Date_End == null;

    }

    @Override
    public int hashCode() {
        int result = CountryName != null ? CountryName.hashCode() : 0;
        result = 31 * result + (HotelName != null ? HotelName.hashCode() : 0);
        result = 31 * result + (CoastName != null ? CoastName.hashCode() : 0);
        result = 31 * result + (Price != null ? Price.hashCode() : 0);
        result = 31 * result + (Date_Start != null ? Date_Start.hashCode() : 0);
        result = 31 * result + (Date_End != null ? Date_End.hashCode() : 0);
        result = 31 * result + DifferenceBetweenDates;
        result = 31 * result + TotalPriceForCurrentVoucher;
        return result;
    }

    public int getTotalPriceVouchers() {
        return TotalPriceVouchers;
    }

    public void setTotalPriceVouchers(int totalPriceVouchers) {
        TotalPriceVouchers = totalPriceVouchers;
    }

    public int getTotalPriceWithSale() {
        return TotalPriceWithSale;
    }

    public void setTotalPriceWithSale(int totalPriceWithSale) {
        TotalPriceWithSale = totalPriceWithSale;
    }
}
