package com.subramanians.interviewpanel.dto;

public class Candidate {
	private int S_No;
	private String Name;
	private int Age;
	private String Qualification;
	private int Experience;
	public Candidate(int s_no,String name,int age,String qualification,int exp)
	{
		this.S_No=s_no;
		this.Name=name;
		this.Age=age;
		this.Qualification=qualification;
		this.Experience=exp;
	}
	public int getS_No() {
		return S_No;
	}
	public void setS_No(int s_No) {
		S_No = s_No;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public int getExperience() {
		return Experience;
	}
	public void setExperience(int experience) {
		Experience = experience;
	}
	
}
