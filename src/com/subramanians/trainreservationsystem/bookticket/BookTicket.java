package com.subramanians.trainreservationsystem.bookticket;

import java.time.DateTimeException;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.subramanians.trainreservationsystem.dto.Passenger;
import com.subramanians.trainreservationsystem.repo.TrainReservationRepository;

public class BookTicket {
	Scanner scanner=new Scanner(System.in);
	private BookTicketViewModel bookTicketViewModel;
	TrainReservationRepository repo;
	
	public BookTicket()
	{
		bookTicketViewModel=new BookTicketViewModel(this);
		this.repo=TrainReservationRepository.getInstance();
	}
	
	public void showTrains(String date,String source,String destination)
	{
		bookTicketViewModel.showTrains(date,source,destination);
		return;
	}
	
	public void showMessage(String msg) {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("\t"+msg);
	}
	
	public void onSuccess(JSONArray retrieved)
	{
		System.out.println("--------------------------------");
		if(retrieved==null)
		{
			showMessage("Error In Fetching Train Details");
		}else
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
			System.out.println("--------------------------------");
			System.out.println("Enter the Choice of Train: ");
			int choice=scanner.nextInt();
			bookTicketViewModel.getTrainavailability(choice);
			getPassengerDetails(choice);
		}
		return;
	}

	public void getDetails() {
		System.out.println("Enter Date in DD/MM/YYYY: ");
		String date=scanner.next();
		try {
			if(bookTicketViewModel.validateDate(date))
			{
				System.out.println("Enter the Source Station: ");
				String source=scanner.next();
				System.out.println("Enter the Destination Station: ");
				String destination=scanner.next();
				showTrains(date, source, destination);
			}
		} catch (DateTimeException e) {
			System.out.println("Invalid Date Format!");
		}
		return;
	}

	private void getPassengerDetails(int choice) {
		System.out.println("---Fill Passenger Details---");
		int Id=0;
		if(!repo.getBookedTickets().isEmpty())
		{
			Id=repo.getBookedTickets().size();
		}
		System.out.println("Enter the Passenger Name: ");
		String name=scanner.next();
		System.out.println("Enter the Passenger Age: ");
		byte age=scanner.nextByte();
		System.out.println("Enter Berth Preference(L,M,U): ");
		char berth=scanner.next().charAt(0);
		Passenger p=new Passenger(Id+1,name,age,Character.toUpperCase(berth));
		bookTicketViewModel.bookTicket(choice,p);
	}
}
