package com.subramanians.flightbooking.options;

import java.util.Scanner;

public class OptionsView {
	OptionsViewModel optionsViewModel;
	
	public OptionsView()
	{
		this.optionsViewModel=new OptionsViewModel(this);
	}
	
	public void showOptions()
	{
		Scanner scanner=new Scanner(System.in);
		print("Welcome to Air India");
		print("");
		print("");
		while(optionsViewModel.run)
		{
			print("Enter your Option: ");
			print("(1 -  Booking, 2 - Get PNR Status, 3 - Booked Tickets, 4 - Cancel Tickets, 5 - Search Passenger, "
					+ "6 - Change ticket status of the passenger, 7 - List Flight Routes, 8 - Add Flight Routes, 9 - Exit");
			int selected;
			do {
				selected = scanner.nextInt();
			}while(optionsViewModel.isValidOption(selected));
			optionsViewModel.showSelected(selected);
		}
	}

	public void bookTicket()
	{
		Scanner scanner = new Scanner(System.in);
		print(" ## Plan My Journey ##");
		print("");
		print("From Station: ");
		String from = scanner.nextLine();
		print("To Station: ");
		String to = scanner.nextLine();
		if(optionsViewModel.showAvailable(from,to))
		{
			print("Enter Fight Number: ");
			int flightnumber;
			do {
				flightnumber=scanner.nextInt();
			}while(optionsViewModel.isValidFlight(flightnumber));
			optionsViewModel.selectedFlight(flightnumber);
			print("Enter Number Of Passengers: ");
			int passenger = scanner.nextInt();
			for(int i=0;i<passenger;i++)
			{
				print("Enter Passenger "+(i+1)+" details: ");
				print("");
				print("Name: ");
				String name=scanner.nextLine();
				print("Age: ");
				int age=scanner.nextInt();
				scanner.nextLine();
				print("Gender: ");
				String gender = scanner.nextLine();
				print("Id: ");
				int id = scanner.nextInt();
				optionsViewModel.addPassenger(name,age,gender,id);
			}
			int totalFare = optionsViewModel.selected.getFare() * passenger;
			print("Total Fare: "+ totalFare);
			print("");
			print("1-Pay ,2-Cancel ,3-Reschedule");
			int payment = scanner.nextInt();
			optionsViewModel.selectedPaymentOption(payment,totalFare);
		}else {
			return;
		}
		
	}

	public void getPnr() {
		Scanner scanner=new Scanner(System.in);
		print("Enter the pnr number: ");
		int pnr = scanner.nextInt();
		optionsViewModel.getTicketByPnr(pnr);
		
	}

	public void bookedTickets() {
		optionsViewModel.showBookedTickets();
		
	}

	public void cancelTicket() {
		Scanner scanner = new Scanner(System.in);
		print("Enter PNR Number: ");
		int pnr = scanner.nextInt();
		print("Do you want to cancel the ticket?");
		scanner.nextLine();
		String cnfrm = scanner.nextLine();
		if(cnfrm.equals("yes"))
		{
			optionsViewModel.cancelTicket(pnr);
		}
	}

	public void searchPassenger() {
		// TODO Auto-generated method stub
		
	}

	public void changeStatus() {
		// TODO Auto-generated method stub
		
	}

	public void flightRoutes() {
		// TODO Auto-generated method stub
		
	}

	public void addFlight() {
		// TODO Auto-generated method stub
		
	}
	
	public void print(String msg) {
		System.out.println(msg);
	}
}
