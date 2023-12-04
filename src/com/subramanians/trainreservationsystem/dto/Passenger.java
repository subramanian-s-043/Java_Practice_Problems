package com.subramanians.trainreservationsystem.dto;

public class Passenger {
	private int passengerId;
	private String passengerName;
	private byte age;
	private int trainNo;
	private char berthPreference;
	private byte ticketStatus;
	private String allottedSeat;
	
	public Passenger(int Id,String name,byte age,char berth)
	{
		setPassengerId(Id);
		setAge(age);
		setPassengerName(name);
		setBerthPreference(berth);
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public char getBerthPreference() {
		return berthPreference;
	}
	public void setBerthPreference(char berthPreference) {
		this.berthPreference = berthPreference;
	}
	public byte getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(byte ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public String getAllottedSeat() {
		return allottedSeat;
	}
	public void setAllottedSeat(String allottedSeat) {
		this.allottedSeat = allottedSeat;
	}
}

/*
•	passengerID: Auto-incremented
•	passengerName: String
•	passengerAge: byte
•	ticketStatus: byte
•	trainNo: Int
•	berthPreference: Character
•	allottedSeat: String
*/