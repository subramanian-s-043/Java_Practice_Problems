package com.subramanians.flightbooking.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import com.subramanians.flightbooking.dto.Flight;
import com.subramanians.flightbooking.dto.Passenger;
import com.subramanians.flightbooking.dto.Ticket;

public class FlightRepo {
	static FlightRepo repo;
	List<Flight> schedules = new ArrayList<>();
	List<Passenger> passengers = new ArrayList<>();
	List<Ticket> tickets = new ArrayList<>();
	
	public static FlightRepo getInstance()
	{
		if(repo==null)
		{
			repo=new FlightRepo();
		}
		return repo;
	}
	
	
	public boolean hasSchedule() throws ClassNotFoundException, IOException {
		readSchedule();
		if(schedules.isEmpty())
			return false;
		return true;
	}
	
	public void addSchedule(Flight flight) {
		schedules.add(flight);
		System.out.println(flight.getFlightName());
	}
	
	@SuppressWarnings("unchecked")
	private void readSchedule() throws IOException, ClassNotFoundException {
		String filePath = new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\flightbooking\\Schedules.txt";
		 FileInputStream fileIn = new FileInputStream(filePath);
         ObjectInputStream objectIn = new ObjectInputStream(fileIn);
         schedules = (List<Flight>) objectIn.readObject();
         objectIn.close();
	}
	
	public void saveSchedule() throws IOException {
		String filePath = new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\flightbooking\\Schedules.txt";
		FileOutputStream fo = new FileOutputStream(filePath);
		ObjectOutputStream objout = new ObjectOutputStream(fo);
		objout.writeObject(schedules);
		objout.close();
	}
	
	public List<Flight> getAvailable(String from, String to) {
		List<Flight> available = new ArrayList<>();
		for(int i=0;i<schedules.size();i++)
		{
			Flight temp = schedules.get(i);
			if(temp.getRoutes().contains(from) && temp.getRoutes().contains(to))
			{
				available.add(temp);
			}
		}
		return available.isEmpty() ? null : available;
	}
	
	public boolean validFlight() {
		// Validation
		return true;
	}
	
	public void addPassenger(Passenger newPassenger) {
		passengers.add(newPassenger);
		
	}
	
	public int getPnr() {
		if(tickets.isEmpty())
		{
			return 1;
		}else {
			return tickets.getLast().getPnrNumber() + 1;
		}
	}
	
	public void addTicket(Ticket newTicket) {
		tickets.add(newTicket);
		
	}


	public Ticket getTicket(int pnr) {
		for(int i=0;i<tickets.size();i++)
		{
			Ticket curr = tickets.get(i);
			if(curr.getPnrNumber()==pnr)
			{
				return curr;
			}
		}
		return null;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}


	public boolean cancelTicket(Ticket retrieve) {
		if(retrieve!=null)
		{
			tickets.remove(retrieve);
		}
		return false;
	}

}
