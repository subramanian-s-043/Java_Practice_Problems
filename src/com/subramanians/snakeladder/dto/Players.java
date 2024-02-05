package com.subramanians.snakeladder.dto;

public class Players {
	private String name;
	private int currPos;
	private int prevPos;
	
	public Players(String name)
	{
		this.name=name;
		this.currPos=0;
		this.prevPos=0;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrPos() {
		return currPos;
	}
	public void setCurrPos(int currPos) {
		this.currPos = currPos;
	}
	public int getPrevPos() {
		return prevPos;
	}
	public void setPrevPos(int prevPos) {
		this.prevPos = prevPos;
	}
	
}
