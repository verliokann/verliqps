package ru.verlioka.cmf.appservices.tourvauchers.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vauchers")
public class VouchersEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaucher_id", nullable = false, unique = true)
    private Long id;
	
	@Column(name = "country", nullable = false)
    private String country;
	
	@Column(name = "seaside", nullable = false)
    private String seaside;
	
	@Column(name = "hotel", nullable = false)
    private String hotel;
	
	@Column(name = "rating", nullable = false)
    private int rating;
	
	@Column(name = "cost", nullable = false)
    private float cost;
	
	@Column(name = "dayscount", nullable = false)
    private int dayscount;
	
	@Column(name = "beachtype", nullable = false)
    private String beachtype;
	
	@Column(name = "startdate", nullable = false)
    private Date startdate;
	
	@Column(name = "finishdate", nullable = false)
    private Date finishdate;
	
	@Column(name = "istravelpaid", nullable = false)
    private boolean istravelpaid;
	
	@Column(name = "isvisaneed", nullable = false)
    private boolean isvisaneed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSeaside() {
		return seaside;
	}

	public void setSeaside(String seaside) {
		this.seaside = seaside;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getDayscount() {
		return dayscount;
	}

	public void setDayscount(int dayscount) {
		this.dayscount = dayscount;
	}

	public String getBeachtype() {
		return beachtype;
	}

	public void setBeachtype(String beachtype) {
		this.beachtype = beachtype;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public boolean isIstravelpaid() {
		return istravelpaid;
	}

	public void setIstravelpaid(boolean istravelpaid) {
		this.istravelpaid = istravelpaid;
	}

	public boolean isIsvisaneed() {
		return isvisaneed;
	}

	public void setIsvisaneed(boolean isvisaneed) {
		this.isvisaneed = isvisaneed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID="+id+" country="+country+" seaside="+seaside+" hotel="+hotel+" rating="+rating+" cost="+cost+" days="+dayscount+" from="+startdate+" to="+finishdate;
		
	}

}
