package ru.verlioka.cmf.appservices.Am2200.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "vouchers")
public class VouchersEntity {

    @Id
    @Column(name = "id_voucher", unique = true)
    private Integer Id_Voucher;

    @Column(name = "start_date")
    private Date Start_Date;

    @Column(name = "end_date")
    private Date End_Date;

    @Column(name = "price")
    private Integer Price;

    @Column(name = "amountofdays")
    private Integer AmountOfDays;

    @Column(name = "ispaid")
    private boolean IsPaid;

    @Column(name = "isvisaneed")
    private boolean IsVisaNeed;

    @ManyToOne
    @JoinColumn(name = "id_coast")
    private CoastsEntity Coast;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private CountriesEntity Country;

    @ManyToOne
    @JoinColumn(name = "id_hotel")
    private HotelsEntity Id_Hotel;

    public Integer getId_Voucher() {
        return Id_Voucher;
    }

    public void setId_Voucher(Integer id_Voucher) {
        Id_Voucher = id_Voucher;
    }

    public Date getStart_Date() {
        return Start_Date;
    }

    public void setStart_Date(Date start_Date) {
        Start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return End_Date;
    }

    public void setEnd_Date(Date end_Date) {
        End_Date = end_Date;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getAmountOfDays() {
        return AmountOfDays;
    }

    public void setAmountOfDays(Integer amountOfDays) {
        AmountOfDays = amountOfDays;
    }

    public boolean isPaid() {
        return IsPaid;
    }

    public void setPaid(boolean paid) {
        IsPaid = paid;
    }

    public boolean isVisaNeed() {
        return IsVisaNeed;
    }

    public void setVisaNeed(boolean visaNeed) {
        IsVisaNeed = visaNeed;
    }

    public CoastsEntity getCoast() {
        return Coast;
    }

    public void setCoast(CoastsEntity coast) {
        Coast = coast;
    }

    public CountriesEntity getCountry() {
        return Country;
    }

    public void setCountry(CountriesEntity country) {
        Country = country;
    }

    public HotelsEntity getId_Hotel() {
        return Id_Hotel;
    }

    public void setId_Hotel(HotelsEntity id_Hotel) {
        Id_Hotel = id_Hotel;
    }
}
