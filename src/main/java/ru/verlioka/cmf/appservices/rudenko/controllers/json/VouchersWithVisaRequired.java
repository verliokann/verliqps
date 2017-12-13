package ru.verlioka.cmf.appservices.rudenko.controllers.json;

import java.sql.Date;

public class VouchersWithVisaRequired implements Comparable<VouchersWithVisaRequired> {
    private Long voucherId;
    private String countryName;
    private String hotelName;
    private Date start;
    private Date end;
    private Double cost;

    public VouchersWithVisaRequired() {
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public int compareTo(VouchersWithVisaRequired o) {
        return this.getHotelName().compareTo(o.getHotelName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VouchersWithVisaRequired that = (VouchersWithVisaRequired) o;

        return (getVoucherId() != null ? getVoucherId().equals(that.getVoucherId()) : that.getVoucherId() == null) &&
                (getCountryName() != null ? getCountryName().equals(that.getCountryName()) : that.getCountryName() == null) &&
                (getHotelName() != null ? getHotelName().equals(that.getHotelName()) : that.getHotelName() == null) &&
                (getStart() != null ? getStart().equals(that.getStart()) : that.getStart() == null) &&
                (getEnd() != null ? getEnd().equals(that.getEnd()) : that.getEnd() == null) &&
                (getCost() != null ? getCost().equals(that.getCost()) : that.getCost() == null);
    }

    @Override
    public int hashCode() {
        int result = getVoucherId() != null ? getVoucherId().hashCode() : 0;
        result = 31 * result + (getCountryName() != null ? getCountryName().hashCode() : 0);
        result = 31 * result + (getHotelName() != null ? getHotelName().hashCode() : 0);
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        result = 31 * result + (getEnd() != null ? getEnd().hashCode() : 0);
        result = 31 * result + (getCost() != null ? getCost().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VouchersWithVisaRequired{" +
                "voucherId=" + voucherId +
                ", countryName='" + countryName + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", cost=" + cost +
                '}';
    }
}
