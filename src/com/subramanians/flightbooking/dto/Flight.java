package com.subramanians.flightbooking.dto;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

public class Flight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int flightNumber;
	private String flightName;
	private LocalTime depature;
	private LocalTime arrival;
	private List<String> routes;
	private int totalSeats;
	private int fare;
	
	public Flight(int number,String name,LocalTime dep,LocalTime arrival,List<String> routes,int seats,int fare) {
		this.flightNumber=number;
		this.flightName=name;
		this.depature=dep;
		this.arrival=arrival;
		this.routes=routes;
		this.totalSeats=seats;
		this.fare=fare;
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public LocalTime getDepature() {
		return depature;
	}
	public void setDepature(LocalTime depature) {
		this.depature = depature;
	}
	public LocalTime getArrival() {
		return arrival;
	}
	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}
	public List<String> getRoutes() {
		return routes;
	}
	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}
