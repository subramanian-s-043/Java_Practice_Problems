package com.subramanians.cricketscore.dto;

public class Formats {
	private String formatName;
	private int overs;
	
	public Formats(String name,int overs) {
		this.formatName=name;
		this.overs=overs;
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}
	
}
