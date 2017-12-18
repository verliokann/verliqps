package ru.verlioka.cmf.appservices.rudenko.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "vouchers")
public class VoucherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voucher_id", nullable = false, unique = true)
    private Long id;

    @OneToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private HotelEntity hotel;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Column(name = "days", nullable = false)
    private Integer days;

    @Column(name = "start", nullable = false)
    private Date start;

    @Column(name = "end")
    private Date end = null;

    @Column(name = "travel_expenses_included")
    private Boolean travelExpensesIncluded = false;

    public VoucherEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        if (end == null) {
            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.add(Calendar.DATE, days);
            end = new Date(c.getTimeInMillis());
        }

        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Boolean getTravelExpensesIncluded() {
        return travelExpensesIncluded;
    }

    public void setTravelExpensesIncluded(Boolean travelExpensesIncluded) {
        this.travelExpensesIncluded = travelExpensesIncluded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VoucherEntity that = (VoucherEntity) o;

        return getId().equals(that.getId()) &&
                getHotel().equals(that.getHotel()) &&
                getCost().equals(that.getCost()) &&
                getDays().equals(that.getDays()) &&
                getStart().equals(that.getStart()) &&
                getEnd().equals(that.getEnd()) &&
                getTravelExpensesIncluded().equals(that.getTravelExpensesIncluded());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getHotel().hashCode();
        result = 31 * result + getCost().hashCode();
        result = 31 * result + getDays().hashCode();
        result = 31 * result + getStart().hashCode();
        result = 31 * result + getEnd().hashCode();
        result = 31 * result + getTravelExpensesIncluded().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "VoucherEntity{" +
                "id=" + id +
                ", hotel=" + hotel +
                ", cost=" + cost +
                ", days=" + days +
                ", start=" + start +
                ", end=" + end +
                ", travelExpensesIncluded=" + travelExpensesIncluded +
                '}';
    }
}
