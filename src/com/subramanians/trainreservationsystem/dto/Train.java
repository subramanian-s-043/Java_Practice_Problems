package com.subramanians.trainreservationsystem.dto;

public class Train {
	private int trainNo;
	private String trainName;
	private String trainSource;
	private String trainDestination;
	private String trainTravelDuration;
	private String trainArrivalTime;
	private String trainDepatureTime;
	
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainSource() {
		return trainSource;
	}
	public void setTrainSource(String trainSource) {
		this.trainSource = trainSource;
	}
	public String getTrainDestination() {
		return trainDestination;
	}
	public void setTrainDestination(String trainDestination) {
		this.trainDestination = trainDestination;
	}
	public String getTrainTravelDuration() {
		return trainTravelDuration;
	}
	public void setTrainTravelDuration(String trainTravelDuration) {
		this.trainTravelDuration = trainTravelDuration;
	}
	public String getTrainArrivalTime() {
		return trainArrivalTime;
	}
	public void setTrainArrivalTime(String trainArrivalTime) {
		this.trainArrivalTime = trainArrivalTime;
	}
	public String getTrainDepatureTime() {
		return trainDepatureTime;
	}
	public void setTrainDepatureTime(String trainDepatureTime) {
		this.trainDepatureTime = trainDepatureTime;
	}
}

/*
•	trainNo: Int
•	trainName: String
•	trainSource: String
•	trainDestination: String
•	trainTravelDuration: Time
•	trainDepature: Time
•	trainArrival: Time
*/