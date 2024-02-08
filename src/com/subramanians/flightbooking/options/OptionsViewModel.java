package com.subramanians.flightbooking.options;

import java.time.Duration;
import java.util.List;

import com.subramanians.flightbooking.dto.Flight;
import com.subramanians.flightbooking.dto.Passenger;
import com.subramanians.flightbooking.dto.Ticket;
import com.subramanians.flightbooking.repository.FlightRepo;

public class OptionsViewModel {
	OptionsView optionsView;
	FlightRepo repo;
	List<Flight> available;
	Flight selected;
	List<Passenger> currentPassengers;
	boolean run = true;
	
	public OptionsViewModel(OptionsView optionsView)
	{
		this.optionsView=optionsView;
		this.repo=FlightRepo.getInstance();
	}

	public void showSelected(int selected) {
		switch(selected)
		{
		case 1:
			optionsView.bookTicket();
			break;
		case 2:
			optionsView.getPnr();
			break;
		case 3:
			optionsView.bookedTickets();
			break;
		case 4:
			optionsView.cancelTicket();
			break;
		case 5:
			optionsView.searchPassenger();
			break;
		case 6:
			optionsView.changeStatus();
			break;
		case 7:
			optionsView.flightRoutes();
			break;
		case 8:
			optionsView.addFlight();
			break;
		case 9:
			run = false;
			break;
		}
		
	}

	public boolean isValidOption(int selected) {
		if(selected < 1 || selected > 9)
			return true;
		return false;
	}

	public boolean showAvailable(String from, String to) {
		available = repo.getAvailable(from,to);
		if(available != null)
		{
			optionsView.print("Available Flights");
			for(int i=0;i<available.size();i++)
			{
				Flight curr = available.get(i);
				printFlightDetails(curr, curr.getFare());
			}
			return true;
		}else {
			optionsView.print("No Flight Found");
			return false;
		}
	}

	public boolean isValidFlight(int flightnumber) {
		if(repo.validFlight())
		{
			return false;
		}
		optionsView.print("Enter Valid flight Number");
		return true;
	}

	public void addPassenger(String name, int age, String gender, int id) {
		Passenger newPassenger = new Passenger(age,name,id,gender);
		currentPassengers.add(newPassenger);
		repo.addPassenger(newPassenger);
		
	}

	public void selectedFlight(int flightnumber) {
		for(int i=0;i<available.size();i++)
		{
			if(available.get(i).getFlightNumber()==flightnumber)
			{
				selected = available.get(i);
				break;
			}
		}
	}

	public void selectedPaymentOption(int payment,int totalFare) {
		if(payment==1)
		{
			int pnr = repo.getPnr();
			Ticket newTicket = new Ticket(pnr,currentPassengers,selected,"CNF",totalFare);
			repo.addTicket(newTicket);
			optionsView.print("Ticket Booked Successfully");
			optionsView.print("");
			optionsView.print("Ticket Details");
			optionsView.print("");
			optionsView.print("Flight Details");
			optionsView.print("-----------------");
			printFlightDetails(selected, totalFare);
			optionsView.print("");
			optionsView.print("Passenger Details");
			optionsView.print("-----------------");
			printPassengerDetails(currentPassengers,"CNF");
		}
		
	}
	
	public void getTicketByPnr(int pnr) {
		Ticket retrieved = repo.getTicket(pnr);
		if(retrieved!=null)
		{
			optionsView.print("Ticket Details");
			optionsView.print("");
			optionsView.print("Flight Details");
			optionsView.print("-----------------");
			printFlightDetails(retrieved.getFlight(), retrieved.getTotalFare());
			optionsView.print("");
			optionsView.print("Passenger Details");
			optionsView.print("-----------------");
			printPassengerDetails(retrieved.getPassengers(),retrieved.getStatus());
		}else {
			optionsView.print("Invalid PNR");
		}
	}
	
	private void printPassengerDetails(List<Passenger> currentPassengers2, String status) {
		for(int i=0;i<currentPassengers2.size();i++)
		{
			Passenger curr = currentPassengers2.get(i);
			optionsView.print((i+1)+". name: "+curr.getName()+" || Age: "+curr.getAge()+" || Gender "
					+ ": "+curr.getGender()+" || Id : "+curr.getId()+" || Status: "+status);
		}
	}

	public void printFlightDetails(Flight curr,int fare) {
		Duration duration = Duration.between(curr.getDepature(), curr.getArrival());
		long travelTime = duration.toHours();
		optionsView.print("Flight no: "+curr.getFlightNumber()+" || name: "+curr.getFlightName()+" || Depature "
				+ "Time: "+curr.getDepature().toString()+" || Arrival Time: "+curr.getArrival().toString()+" || "
						+ "Travel Time: "+travelTime+" Fare:"+fare+" seats: "+curr.getTotalSeats());
	}

	public void showBookedTickets() {
		List<Ticket> totalTickets = repo.getTickets();
		optionsView.print("Total Tickets Booked: "+totalTickets.size());
		for(int i=0;i<totalTickets.size();i++)
		{
			Ticket curr = totalTickets.get(i);
			optionsView.print("Ticket Details");
			optionsView.print("");
			optionsView.print("Flight Details");
			optionsView.print("-----------------");
			printFlightDetails(curr.getFlight(), curr.getTotalFare());
			optionsView.print("");
			optionsView.print("Passenger Details");
			optionsView.print("-----------------");
			printPassengerDetails(curr.getPassengers(),curr.getStatus());
		}
	}

	public void cancelTicket(int pnr) {
		Ticket retrieve = repo.getTicket(pnr);
		if(repo.cancelTicket(retrieve))
		{
			optionsView.print("Your Ticket Cancelled Successfully. Your refund"+retrieve.getTotalFare()+"will be processed soon.");
		}else {
			optionsView.print("Invalid PNR");
		}
		
	}

	public void getPassengerById(int id) {
		Passenger retrieve = repo.getPassengerById(id);
		if(retrieve!=null)
		{
			printPassenger(retrieve);
		}else {
			optionsView.print("Invalid Passenger Id");
		}
	}

	private void printPassenger(Passenger retrieve) {
		optionsView.print((1)+". name: "+retrieve.getName()+" || Age: "+retrieve.getAge()+" || Gender "
				+ ": "+retrieve.getGender()+" || Id : "+retrieve.getId());
		
	}

	public void changeStatus(int pnr, int status) {
		Ticket retrieve = repo.getTicket(pnr);
		if(status==1)
		{
			retrieve.setStatus("CNF");
		}else {
			retrieve.setStatus("CANCEL");
		}
		repo.removeTicket(retrieve);
		repo.addTicket(retrieve);
		optionsView.print("Ticket Details");
		optionsView.print("");
		optionsView.print("Flight Details");
		optionsView.print("-----------------");
		printFlightDetails(retrieve.getFlight(), retrieve.getTotalFare());
		optionsView.print("");
		optionsView.print("Passenger Details");
		optionsView.print("-----------------");
		printPassengerDetails(retrieve.getPassengers(),retrieve.getStatus());
	}

}
