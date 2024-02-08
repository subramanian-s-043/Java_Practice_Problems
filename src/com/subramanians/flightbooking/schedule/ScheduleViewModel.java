package com.subramanians.flightbooking.schedule;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.subramanians.flightbooking.dto.Flight;
import com.subramanians.flightbooking.repository.FlightRepo;

public class ScheduleViewModel {
	ScheduleView scheduleView;
	FlightRepo repo;
	public ScheduleViewModel(ScheduleView scheduleView)
	{
		this.scheduleView=scheduleView;
		this.repo = FlightRepo.getInstance();
	}
	
	public boolean hasSchedule() {
		try {
			if(repo.hasSchedule())
			{
				return true;
			}
		} catch (ClassNotFoundException | IOException e) {
			return false;
		}
		return false;
	}

	public void addSchedule(int flightNum, String flightName, String routes, String dep, String arr, int totalSeats,
			int fare) 
	{
		List<String> flightRoutes = new ArrayList<>();
		String[] tempRoutes = routes.split(",");
		for(int i=0;i<tempRoutes.length;i++)
		{
			flightRoutes.add(tempRoutes[i]);
		}
		LocalTime depatureTime = LocalTime.parse(dep,DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime arrivalTime = LocalTime.parse(arr,DateTimeFormatter.ofPattern("HH:mm"));
		repo.addSchedule(new Flight(flightNum,flightName,arrivalTime,depatureTime,flightRoutes,totalSeats,fare));
	}

	public void saveSchedule() {
		try {
			repo.saveSchedule();
		} catch (IOException e) {
			scheduleView.print("Error In Saving Schedules");
		}
		
	}
}
