package com.subramanians.flightbooking.dto;

import java.util.List;

public class Ticket {
	private int pnrNumber;
	private List<Passenger> passengers;
	private Flight flight;
	private String status;
	private int totalFare;
	public Ticket(int pnr,List<Passenger> passenger,Flight flight,String status,int fare)
	{
		this.pnrNumber=pnr;
		this.passengers=passenger;
		this.flight=flight;
		this.status=status;
		this.totalFare=fare;
	}
	
	public int getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
