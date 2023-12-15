package com.subramanians.tablebooking.dto;

public class Table {
	private String tableNo;
	private int tableCapacity;
	public Table(String tableNo,int tableCapacity)
	{
		setTableNo(tableNo);
		setTableCapacity(tableCapacity);
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public int getTableCapacity() {
		return tableCapacity;
	}
	public void setTableCapacity(int tableCapacity) {
		this.tableCapacity = tableCapacity;
	}
}
