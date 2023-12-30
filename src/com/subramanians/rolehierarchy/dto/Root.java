package com.subramanians.rolehierarchy.dto;

public class Root {
	private String name;
	private String role;
	
	public Root(String name)
	{
		this.role=name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
