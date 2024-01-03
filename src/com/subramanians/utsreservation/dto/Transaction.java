package com.subramanians.utsreservation.dto;

public class Transaction {
	private int Id;
	private int amount;
	private Boolean isTicket;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Boolean getIsTicket() {
		return isTicket;
	}
	public void setIsTicket(Boolean isTicket) {
		this.isTicket = isTicket;
	}
	
	
}
