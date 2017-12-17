package ru.verlioka.cmf.appservices.tourvauchers.controllers;

public class HotelReport {
	
	String name;
	String country;
	String seaside;
	String startDate;
	String finishDate;
	Double cost;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Hotel =" + name + " Country =" +country + " Seaside=" + seaside + " Start Date="+startDate+" Finish Date="+finishDate+" Price"+cost;
	}

}
