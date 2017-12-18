package ru.verlioka.cmf.appservices.rudenko.controllers.json;

import java.sql.Date;

public class MidLengthVoucher implements Comparable<MidLengthVoucher> {
    private Long voucherId;
    private String country;
    private Integer days;
    private Date start;

    public MidLengthVoucher() {
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    @Override
    public int compareTo(MidLengthVoucher o) {
        return Integer.compare(this.getDays(), o.getDays());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MidLengthVoucher that = (MidLengthVoucher) o;

        return (getVoucherId() != null ? getVoucherId().equals(that.getVoucherId()) : that.getVoucherId() == null) &&
                (getCountry() != null ? getCountry().equals(that.getCountry()) : that.getCountry() == null) &&
                (getDays() != null ? getDays().equals(that.getDays()) : that.getDays() == null) &&
                (getStart() != null ? getStart().equals(that.getStart()) : that.getStart() == null);
    }

    @Override
    public int hashCode() {
        int result = getVoucherId() != null ? getVoucherId().hashCode() : 0;
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getDays() != null ? getDays().hashCode() : 0);
        result = 31 * result + (getStart() != null ? getStart().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MidLengthVoucher{" +
                "voucherId=" + voucherId +
                ", country='" + country + '\'' +
                ", days=" + days +
                ", start=" + start +
                '}';
    }
}
