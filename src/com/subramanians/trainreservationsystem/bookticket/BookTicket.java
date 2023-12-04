package com.subramanians.trainreservationsystem.bookticket;

import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.subramanians.trainreservationsystem.dto.Passenger;

public class BookTicket {
	Scanner scanner=new Scanner(System.in);
	private BookTicketViewModel bookTicketViewModel;
	
	public BookTicket()
	{
		bookTicketViewModel=new BookTicketViewModel(this);
	}
	
	public void showTrains(String date,String source,String destination)
	{
		bookTicketViewModel.showTrains(date,source,destination);
		return;
	}
	
	public void onSuccess(JSONArray retrieved)
	{
		for(int i=0;i<retrieved.size();i++)
		{
			JSONObject element=(JSONObject)retrieved.get(i);
			System.out.print((i+1));
			System.out.print(" Train Number: "+element.get("TrainNo")+"  ");
			System.out.print("Train Name: "+element.get("TrainName")+"  ");
			System.out.print("Source Station: "+element.get("Source")+"  ");
			System.out.print("Destination Station: "+element.get("Destination")+"  ");
			System.out.print("Travel Time: "+element.get("Duration")+"  ");
			System.out.println();
		}
		return;
	}

	public void getDetails() {
		System.out.println("Enter Date in DD-MM-YYYY: ");
		String date=scanner.next();
		System.out.println("Enter the Source Station: ");
		String source=scanner.next();
		System.out.println("Enter the Destination Station: ");
		String destination=scanner.next();
		showTrains(date, source, destination);
		System.out.println("Enter the Choice of Train: ");
		int choice=scanner.nextInt();
		bookTicketViewModel.getTrainavailability(choice);
		getPassengerDetails(choice);
		return;
	}

	private void getPassengerDetails(int choice) {
		int Id=0;
		if(!bookTicketViewModel.bookedTickets.isEmpty())
		{
			Id=bookTicketViewModel.bookedTickets.peek().getPassengerId();
		}
		System.out.println("Enter the Passenger Name: ");
		String name=scanner.next();
		System.out.println("Enter the Passenger Age: ");
		byte age=scanner.nextByte();
		System.out.println("Enter Berth Preference(L,M,U): ");
		char berth=scanner.next().charAt(0);
		Passenger p=new Passenger(Id+1,name,age,berth);
		bookTicketViewModel.bookTicket(choice,p);
	}
}
