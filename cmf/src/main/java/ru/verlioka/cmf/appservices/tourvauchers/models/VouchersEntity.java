package ru.verlioka.cmf.appservices.tourvauchers.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vouchers")
public class VouchersEntity {
	
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

    @Column(name = "startdate", nullable = false)
    private Date start;

    @Column(name = "finishdate", nullable=false)
    private Date finish;

    @Column(name = "travel_expenses_included")
    private Boolean travelpaid = false;

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

	public Date getFinish() {
		return finish;
	}

	public void setFinish(Date finish) {
		this.finish = finish;
	}

	public Boolean getTravelpaid() {
		return travelpaid;
	}

	public void setTravelpaid(Boolean travelpaid) {
		this.travelpaid = travelpaid;
	}
	
	@SuppressWarnings("deprecation")
	public int getStartMonth()
	{
		return this.start.getMonth();
	}
	
	@SuppressWarnings("deprecation")
	public int getFinishMonth()
	{
		return this.finish.getMonth();
	}
    
	@Override
    public String toString() {
        return "VoucherEntity{" +
                "id=" + id +
                ", hotel=" + hotel +
                ", cost=" + cost +
                ", days=" + days +
                ", start=" + start +
                ", finish=" + finish +
                ", istravelpaid=" + travelpaid +
                '}';
    }

}
