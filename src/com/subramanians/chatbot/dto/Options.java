package com.subramanians.chatbot.dto;


public class Options {
	private String depth;
	private String Choice;
	
	public Options(String depth,String Choice)
	{
		this.depth=depth;
		this.Choice=Choice;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	public String getChoice() {
		return Choice;
	}
	public void setChoice(String choice) {
		Choice = choice;
	}
	
}
