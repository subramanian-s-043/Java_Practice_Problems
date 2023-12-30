package com.subramanians.rolehierarchy.dto;

public class Staff {
	private String name;
	private String reportingTo;
	private int id;
	
	public Staff(String name,String reportingTo,int id)
	{
		this.name=name;
		this.reportingTo=reportingTo;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
