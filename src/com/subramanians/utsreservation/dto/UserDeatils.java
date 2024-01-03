package com.subramanians.utsreservation.dto;

import java.util.List;

public class UserDeatils {
	private int Id;
	private List<Integer> transacList;
	private List<Integer> ticketId;
	private int availableAmount;
	private String userName;
	private String password;
	private String email;
	private String mobileNumber;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public List<Integer> getTicketId() {
		return ticketId;
	}
	public void setTicketId(List<Integer> ticketId) {
		this.ticketId = ticketId;
	}
	public int getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(int availableAmount) {
		this.availableAmount = availableAmount;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Integer> getTransacList() {
		return transacList;
	}
	public void setTransacList(List<Integer> transacList) {
		this.transacList = transacList;
	}
	
}
