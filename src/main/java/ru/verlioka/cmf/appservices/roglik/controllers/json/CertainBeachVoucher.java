package ru.verlioka.cmf.appservices.roglik.controllers.json;

import java.sql.Date;
import java.util.Objects;

public class CertainBeachVoucher {
    private String countryName;
    private String hotelName;
    private String beachName;
    private Date departureDate;
    private Date arrivalDate;
    private Double cost;
    private Integer days;
    private Double discountedCost;

    public CertainBeachVoucher() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getBeachName() {
        return beachName;
    }

    public void setBeachName(String beachName) {
        this.beachName = beachName;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Double getDiscountedCost() {
        return discountedCost;
    }

    public void setDiscountedCost(Double discountedCost) {
        this.discountedCost = discountedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CertainBeachVoucher that = (CertainBeachVoucher) o;
        return Objects.equals(getCountryName(), that.getCountryName()) &&
                Objects.equals(getHotelName(), that.getHotelName()) &&
                Objects.equals(getBeachName(), that.getBeachName()) &&
                Objects.equals(getDepartureDate(), that.getDepartureDate()) &&
                Objects.equals(getArrivalDate(), that.getArrivalDate()) &&
                Objects.equals(getCost(), that.getCost()) &&
                Objects.equals(getDays(), that.getDays()) &&
                Objects.equals(getDiscountedCost(), that.getDiscountedCost());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCountryName(), getHotelName(), getBeachName(), getDepartureDate(), getArrivalDate(), getCost(), getDays(), getDiscountedCost());
    }

    @Override
    public String toString() {
        return "CertainBeachVoucher{" +
                "countryName='" + countryName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", beachName='" + beachName + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", cost=" + cost +
                ", days=" + days +
                ", discountedCost=" + discountedCost +
                '}';
    }
}
