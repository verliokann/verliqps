package ru.verlioka.cmf.appservices.roglik.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.Objects;

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

    @Column(name = "beach_name", nullable = false)
    private String beachName;

    @Column(name = "beach_type", nullable = false)
    private String beachType;

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

    public String getBeachName() {
        return beachName;
    }

    public void setBeachName(String beachName) {
        this.beachName = beachName;
    }

    public String getBeachType() {
        return beachType;
    }

    public void setBeachType(String beachType) {
        this.beachType = beachType;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoucherEntity that = (VoucherEntity) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getHotel(), that.getHotel()) &&
                Objects.equals(getCost(), that.getCost()) &&
                Objects.equals(getDays(), that.getDays()) &&
                Objects.equals(getBeachName(), that.getBeachName()) &&
                Objects.equals(getBeachType(), that.getBeachType()) &&
                Objects.equals(getStart(), that.getStart()) &&
                Objects.equals(getEnd(), that.getEnd()) &&
                Objects.equals(getTravelExpensesIncluded(), that.getTravelExpensesIncluded());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHotel(), getCost(), getDays(), getBeachName(), getBeachType(), getStart(), getEnd(), getTravelExpensesIncluded());
    }

    @Override
    public String toString() {
        return "VoucherEntity{" +
                "id=" + id +
                ", hotel=" + hotel +
                ", cost=" + cost +
                ", days=" + days +
                ", beachName='" + beachName + '\'' +
                ", beachType='" + beachType + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", travelExpensesIncluded=" + travelExpensesIncluded +
                '}';
    }
}
