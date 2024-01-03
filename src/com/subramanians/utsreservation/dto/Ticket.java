package com.subramanians.utsreservation.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
	private int Id;
	private Station from;
	private Station to;
	private LocalDate dateOfBooking;
	private LocalTime timeOfBooking;
	private LocalTime validUpto;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Station getFrom() {
		return from;
	}
	public void setFrom(Station from) {
		this.from = from;
	}
	public Station getTo() {
		return to;
	}
	public void setTo(Station to) {
		this.to = to;
	}
	public LocalDate getDateOfBooking() {
		return dateOfBooking;
	}
	public void setDateOfBooking(LocalDate dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}
	public LocalTime getTimeOfBooking() {
		return timeOfBooking;
	}
	public void setTimeOfBooking(LocalTime timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}
	public LocalTime getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(LocalTime validUpto) {
		this.validUpto = validUpto;
	}
	
	
}
