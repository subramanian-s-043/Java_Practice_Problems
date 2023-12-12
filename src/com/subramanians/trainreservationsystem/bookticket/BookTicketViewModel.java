package com.subramanians.trainreservationsystem.bookticket;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.subramanians.trainreservationsystem.dto.Passenger;
import com.subramanians.trainreservationsystem.repo.TrainReservationRepository;

public class BookTicketViewModel {
	private BookTicket bookTicket;
	private JSONArray retrieved;
	TrainReservationRepository repo;   
	
	
	public BookTicketViewModel(BookTicket bookTicket) {
		this.bookTicket=bookTicket;
		this.repo=TrainReservationRepository.getInstance();
	}

	public void showTrains(String date,String source,String destination) {
		retrieved = repo.getTrainDetails(date, source, destination);
		bookTicket.onSuccess(retrieved);
		return ;
	}
	
	public void getTrainavailability(int choice) {
		repo.getTrainavailabity(choice);
	}
	
	public void bookTicket(int choice, Passenger p) {
		JSONObject selectedTrain=(JSONObject)retrieved.get(choice-1);
		p.setTrainNo(Integer.valueOf((String) selectedTrain.get("TrainNo")));
		if(p.getBerthPreference()=='L' && repo.getAvailableLowerBerths() >0 ||
			p.getBerthPreference()=='M' && repo.getAvailableMiddleBerths()>0 ||
			p.getBerthPreference()=='U' && repo.getAvailableUpperBerths()>0)
		{
			if(p.getBerthPreference()=='L')
			{
				bookTicket.showMessage("Prefered Berth Given!!");
				String seatNumber=String.valueOf(repo.getLowerBerthsPositions())+"-"+"L";
				p.setAllottedSeat(seatNumber);
				repo.removeLowerBerth();
				p.setTicketStatus((byte) 0);
				repo.bookedTicket(p);
				bookTicket.showMessage("PNR: "+p.getPassengerId());
				bookTicket.showMessage("Ticket Booked Successfully,Seat Number: "+p.getAllottedSeat());
			}
			else if(p.getBerthPreference()=='M')
			{
				bookTicket.showMessage("Prefered Berth Given!!");
				String seatNumber=String.valueOf(repo.getMiddleBerthsPositions())+"-"+"M";
				p.setAllottedSeat(seatNumber);
				repo.removeMiddleBerth();
				p.setTicketStatus((byte) 0);
				repo.bookedTicket(p);
				bookTicket.showMessage("PNR: "+p.getPassengerId());
				bookTicket.showMessage("Ticket Booked Successfully,ticket status: CNF/Seat Number: "+p.getAllottedSeat());
			}
			else if(p.getBerthPreference()=='U')
			{
				bookTicket.showMessage("Prefered Berth Given!!");
				String seatNumber=String.valueOf(repo.getUpperBerthsPositions())+"-"+"U";
				p.setAllottedSeat(seatNumber);
				repo.removeUpperBerth();
				p.setTicketStatus((byte) 0);
				repo.bookedTicket(p);
				bookTicket.showMessage("PNR: "+p.getPassengerId());
				bookTicket.showMessage("Ticket Booked Successfully,ticket status: CNF/Seat Number: "+p.getAllottedSeat());
			}
		}
		else if(repo.getAvailableLowerBerths() > 0)
		{
			bookTicket.showMessage("Lower Berth Given!!");
			String seatNumber=String.valueOf(repo.getLowerBerthsPositions())+"-"+"L";
			p.setAllottedSeat(seatNumber);
			repo.removeLowerBerth();
			p.setTicketStatus((byte)0);
			repo.bookedTicket(p);
			bookTicket.showMessage("PNR: "+p.getPassengerId());
			bookTicket.showMessage("Ticket Booked Successfully,ticket status: CNF/Seat Number: "+p.getAllottedSeat());
		}
		else if(repo.getAvailableMiddleBerths() > 0)
		{
			bookTicket.showMessage("Middle Berth Given!!");
			String seatNumber=String.valueOf(repo.getMiddleBerthsPositions())+"-"+"M";
			p.setAllottedSeat(seatNumber);
			repo.removeMiddleBerth();
			p.setTicketStatus((byte) 0);
			repo.bookedTicket(p);
			bookTicket.showMessage("PNR: "+p.getPassengerId());
			bookTicket.showMessage("Ticket Booked Successfully,ticket status: CNF/Seat Number: "+p.getAllottedSeat());
		}
		else if(repo.getAvailableUpperBerths() > 0)
		{
			bookTicket.showMessage("Upper Berth Given!!");
			String seatNumber=String.valueOf(repo.getUpperBerthsPositions())+"-"+"U";
			p.setAllottedSeat(seatNumber);
			repo.removeUpperBerth();
			p.setTicketStatus((byte) 0);
			repo.bookedTicket(p);
			bookTicket.showMessage("PNR: "+p.getPassengerId());
			bookTicket.showMessage("Ticket Booked Successfully,ticket status: CNF/Seat Number: "+p.getAllottedSeat());
		}
		else if(repo.getAvailableRacTickets() > 0)
		{
			bookTicket.showMessage("No Ticktes Available!!....Booking On RAC");
			String seatNumber=String.valueOf(repo.getAvailableRacTickets())+"-"+"RAC";
			p.setAllottedSeat(seatNumber);
			p.setTicketStatus((byte) 1);
			repo.removeRAC();
			repo.bookedTicket(p);
			repo.addRac(p.getPassengerId());
			bookTicket.showMessage("PNR: "+p.getPassengerId());
			bookTicket.showMessage("Ticket Booked Successfully,ticket status: RAC/Position : "+p.getAllottedSeat());
		}
		else if(repo.getAvailableWaitingList()>0)
		{
			bookTicket.showMessage("Available & RAC Tickets are Full!....Adding to Waiting List");
			String seatNumber=String.valueOf(repo.getWaitingListPositions())+"-"+"WL";
			p.setAllottedSeat(seatNumber);
			p.setTicketStatus((byte) 2);
			repo.bookedTicket(p);
			repo.addWL(p.getPassengerId());
			bookTicket.showMessage("PNR: "+p.getPassengerId());
			bookTicket.showMessage("Ticket Booked Successfully,ticket status: WL/Position : "+p.getAllottedSeat());			
		}else
		{
			bookTicket.showMessage("Train filled!, please choose another");
		}
	}
	
	public void errorMsg(String msg)
	{
		bookTicket.showMessage(msg);
	}

	public boolean validateDate(String date) throws DateTimeException {
		CharSequence t=date;
		DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd/M/yyyy");
	    LocalDate inp= LocalDate.parse(t, pattern);
	    if(inp.isEqual(LocalDate.now()) || inp.isAfter(LocalDate.now()))
	    {
	    	return true;
	    }else
	    {
	    	bookTicket.showMessage("Please Enter Future Date");
	    	return false;
	    }
	}
}
