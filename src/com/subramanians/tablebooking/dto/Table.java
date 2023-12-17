package com.subramanians.tablebooking.dto;

public class Table {
	private String restaurantName;
	private int totalNumberOfTable;
	private int tableCapacity;
	public Table(String restaurantName,int totalNumberOfTable,int tableCapacity)
	{
		setRestaurantName(restaurantName);
		setTotalNumberOfTable(totalNumberOfTable);
		setTableCapacity(tableCapacity);
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public int getTotalNumberOfTable() {
		return totalNumberOfTable;
	}
	public void setTotalNumberOfTable(int tableNo) {
		this.totalNumberOfTable = tableNo;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
}
