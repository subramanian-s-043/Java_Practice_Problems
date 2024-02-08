package com.subramanians.flightbooking.schedule;

import java.util.Scanner;

public class ScheduleView {
	ScheduleViewModel scheduleViewModel;
	
	public ScheduleView() {
		this.scheduleViewModel=new ScheduleViewModel(this);
	}
	
	public void getSchedule()
	{
		if(scheduleViewModel.hasSchedule())
		{
			return;
		}
		print("Welcome to Air India");
		print("Enter Number Of Schedules: ");
		Scanner scanner=new Scanner(System.in);
		int total = scanner.nextInt();
		for(int i=0;i<total;i++)
		{
			print("Schedule "+(i+1));
			print("Enter the Flight Number: ");
			int flightNum = scanner.nextInt();
			scanner.nextLine();
			print("Enter the Flight Name: ");
			String flightName = scanner.nextLine();
			print("Enter the Flight Routes (comma-separated): ");
			String routes = scanner.nextLine();
			print("Enter the depature Time: ");
			String dep = scanner.nextLine();
			print("Enter the Arrival Time: ");
			String arr = scanner.nextLine();
			print("Enter total number of seats: ");
			int totalSeats = scanner.nextInt();
			print("Enter flight fare: ");
			int fare = scanner.nextInt();
			scheduleViewModel.addSchedule(flightNum,flightName,routes,dep,arr,totalSeats,fare);
		}
		scheduleViewModel.saveSchedule();
	}
	
	public void print(String msg)
	{
		System.out.println(msg);
	}
}
