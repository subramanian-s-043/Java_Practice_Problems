package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class People
{
	private String name;
	private int yearOfBirth;
	private int yearOfDeath;
	public People(String name,int yearOfBirth,int yearOfDeath)
	{
		this.name=name;
		this.yearOfBirth=yearOfBirth;
		this.yearOfDeath=yearOfDeath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public int getYearOfDeath() {
		return yearOfDeath;
	}
	public void setYearOfDeath(int yearOfDeath) {
		this.yearOfDeath = yearOfDeath;
	}
	
}
public class AlivePeople {
	static List<People> peoples=new ArrayList<>();
	public static void main(String[] args) {
		peoples.add(new People("John",1900,1925));
		peoples.add(new People("Doe",1925,1965));
		peoples.add(new People("Albert",1965,1985));
		AlivePeople check=new AlivePeople();
		check.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the start year: ");
		int year=scanner.nextInt();
		for(int i=0;i<peoples.size();i++)
		{
			if(peoples.get(i).getYearOfBirth()<=year && peoples.get(i).getYearOfDeath()>year)
			{
				System.out.println(peoples.get(i).getName());
			}
		}
	}
}
