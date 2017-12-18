package ru.verlioka.cmf.appservices.tourvauchers.controllers;

import java.util.Date;

public class VoucherReport {
	
	String country;
	String seaside;
	int rating;
	Date startDate;
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		return "Country ="+country+" Seaside="+seaside+" Rating="+rating+" Start Date="+startDate.toString();
	}

}
