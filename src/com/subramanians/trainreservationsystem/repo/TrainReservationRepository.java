package com.subramanians.trainreservationsystem.repo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.subramanians.trainreservationsystem.dto.Passenger;

public class TrainReservationRepository {
	private static TrainReservationRepository trainRepo;
	private Object readTrainDetails;
	private Object readStationCode;
	private Object readAvailability;
	private JSONParser parser=new JSONParser();
	JSONArray retrieved;
	private JSONObject retrievedTrainDetails;
	private JSONObject retrievedStationCode;
	private JSONObject retrievedAvailability;
	private JSONObject avail;
	
	Connection connection=null;
	private String url="jdbc:mysql://localhost:3306/trainreservationsystem";
	private String username="root";
	private String password="admin";
	Map<Integer,Passenger> bookedTickets=new HashMap<>();
	
    int availableLowerBerths = 0;//normally 1
    int availableMiddleBerths = 0;//normally 1
    int availableUpperBerths = 0;//normally 1
    int availableRacTickets = 0;//normally 1
    int availableWaitingList = 0;//normally 10

    Queue<Integer> waitingList = new LinkedList<>();//queue of WL passengers
    Queue<Integer> racList =  new LinkedList<>();//queu of RAC passengers

    List<Integer> lowerBerthsPositions = new ArrayList<>();//normally 1,2,...1
    List<Integer> middleBerthsPositions = new ArrayList<>();//normally 1,2,...1
    List<Integer> upperBerthsPositions = new ArrayList<>();//normally 1,2,...1
    List<Integer> racPositions = new ArrayList<>();//normally 1,2,...1
    List<Integer> waitingListPositions = new ArrayList<>();//normally 1,2,...10
    
	public TrainReservationRepository()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
			readTrainDetails=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainDetails.json"));
			retrievedTrainDetails=(JSONObject) readTrainDetails;
			readStationCode=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainStationCode.json"));
			retrievedStationCode=(JSONObject) readStationCode;
		} catch (IOException e) {
			System.out.println("Error In Fetching Details");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static TrainReservationRepository getInstance()
	{
		if(trainRepo==null)
		{
			trainRepo=new TrainReservationRepository();
		}
		return trainRepo;
	}

	public JSONArray getTrainDetails(String date,String source,String destination)
	{
		/*
		 * SELECT QUERY
		 * select * from traindetails where trainSource=${source} AND trainDestination=${destination} AND endDate >= ${date} Order By trainTravelDuration;
		 *
		 */
		String stationCode=(String) retrievedStationCode.get(source.replace(" ", "").toUpperCase())+"_"+retrievedStationCode.get(destination.replace(" ", "").toUpperCase());
		retrieved= (JSONArray) retrievedTrainDetails.get(stationCode);
		return retrieved;
	}

	public void getTrainavailabity(int choice) {
		/*
		 * select * from dateschedule where trainNo=${retriveFromList} AND dateOfJourney=${retrieveFromList};
		 */
		if(bookedTickets.isEmpty())
		{
			JSONObject trainIndex=(JSONObject) retrieved.get(choice-1);
			retrieveLowerAvailability(trainIndex);
			retrieveUpperAvailability(trainIndex);
			retrieveMiddleAvailability(trainIndex);
			retrieveRac(trainIndex);
			retrieveWL(trainIndex);	
		}else
		{
			return;
		}
	}

	public void retrieveLowerAvailability(JSONObject trainIndex) {
		try {
			readAvailability=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainAvailability.json"));
		} catch (IOException | ParseException e) {
			System.out.println("Error In Getting Availability....");
		}
		retrievedAvailability=(JSONObject) readAvailability;
		avail=(JSONObject) retrievedAvailability.get(trainIndex.get("TrainNo"));
		int lower=Integer.valueOf((String) avail.get("availableLowerBerth"));
		availableLowerBerths=lower;
		for(int i=0;i<availableLowerBerths;i++)
		{
			if(i==0)
			{
				i++;
			}
			lowerBerthsPositions.add(i);
		}
	}
	
	public void retrieveUpperAvailability(JSONObject trainIndex) {
		int upper=Integer.valueOf((String) avail.get("availableUpperBerth"));
		availableUpperBerths=upper;
		for(int i=0;i<availableUpperBerths;i++)
		{
			if(i==0)
			{
				i++;
			}
			upperBerthsPositions.add(i);
		}
	}
	
	public void retrieveMiddleAvailability(JSONObject trainIndex) {
		int middle=Integer.valueOf((String) avail.get("availableMiddleBerth"));
		availableMiddleBerths=middle;
		for(int i=0;i<availableMiddleBerths;i++)
		{
			if(i==0)
			{
				i++;
			}
			middleBerthsPositions.add(i);
		}
	}
	
	public void retrieveRac(JSONObject trainIndex) {
		int RAC=Integer.valueOf((String) avail.get("availableRac"));
		availableRacTickets=RAC;
		for(int i=(1-availableRacTickets);i<=1;i++)
		{
			if(i==0)
			{
				i++;
			}
			racPositions.add(i);
		}
	}
	
	public void retrieveWL(JSONObject trainIndex) {
		int WL=Integer.valueOf((String) avail.get("availableWL"));
		availableWaitingList=WL;
		for(int i=(1-availableWaitingList);i<=1;i++)
		{
			if(i==0)
			{
				i++;
			}
			waitingListPositions.add(i);
		}
	}
	public void bookedTicket(Passenger p) {
		bookedTickets.put(p.getPassengerId(),p);
		return;
	}
	
	public void addRac(int id) {
		racList.add(id);
		return;
	}
	public void addWL(int id) {
		waitingList.add(id);
		return;
	}
	public void removeLowerBerth()
	{
		availableLowerBerths--;
		lowerBerthsPositions.remove(0);
	}

	public void removeMiddleBerth()
	{
		availableMiddleBerths--;
		middleBerthsPositions.remove(0);
	}
	public void removeUpperBerth()
	{
		availableUpperBerths--;
		upperBerthsPositions.remove(0);
	}
	public void removeRAC()
	{
		availableRacTickets--;
		racPositions.remove(0);
	}
	public void removeWL()
	{
		availableWaitingList--;
		waitingListPositions.remove(0);
	}
	public Map<Integer, Passenger> getBookedTickets() {
		return bookedTickets;
	}
	public int getAvailableLowerBerths() {
		return availableLowerBerths;
	}

	public int getAvailableMiddleBerths() {
		return availableMiddleBerths;
	}

	public int getAvailableUpperBerths() {
		return availableUpperBerths;
	}

	public int getAvailableRacTickets() {
		return availableRacTickets;
	}

	public int getAvailableWaitingList() {
		return availableWaitingList;
	}

	public int getLowerBerthsPositions() {
		return lowerBerthsPositions.get(0);
	}

	public int getMiddleBerthsPositions() {
		return middleBerthsPositions.get(0);
	}

	public int getUpperBerthsPositions() {
		return upperBerthsPositions.get(0);
	}

	public int getRacPositions() {
		return racPositions.get(0);
	}

	public int getWaitingListPositions() {
		return waitingListPositions.get(0);
	}
	public void updateWL()
	{
		if(!waitingList.isEmpty())
		{
			int WLId=waitingList.poll();
			Passenger WLPassenger=bookedTickets.get(WLId);
			int rac=racPositions.get(0);
			availableRacTickets--;
			String[] WLPosition=WLPassenger.getAllottedSeat().split("-");
			WLPassenger.setAllottedSeat(String.valueOf(rac)+"-"+"RAC");
			WLPassenger.setTicketStatus((byte)1);
			waitingListPositions.add(Integer.valueOf(WLPosition[0]));
			Collections.sort(waitingListPositions);
			availableWaitingList++;
		}
	}
	public void removeTicket(int passengerId)
	{
		bookedTickets.remove(passengerId);
	}
	public void restoreLowerSeat(int seatNumber) {
		availableLowerBerths++;
		lowerBerthsPositions.add(seatNumber);
		Collections.sort(lowerBerthsPositions);
		if(!racList.isEmpty())
		{
			int racPassengerId=racList.poll();
			Passenger racPassenger=bookedTickets.get(racPassengerId);
			int lower=lowerBerthsPositions.get(0);
			availableLowerBerths--;
			String[] racPosition=racPassenger.getAllottedSeat().split("-");
			racPassenger.setAllottedSeat(String.valueOf(lower)+"-"+"L");
			racPassenger.setTicketStatus((byte)0);
			racPositions.add(Integer.valueOf(racPosition[0]));
			Collections.sort(racPositions);
			availableRacTickets++;
			updateWL();
		}
	}
	public void restoreMiddleSeat(int seatNumber) {
		availableMiddleBerths++;
		middleBerthsPositions.add(seatNumber);
		Collections.sort(middleBerthsPositions);
		if(!racList.isEmpty())
		{
			int racPassengerId=racList.poll();
			Passenger racPassenger=bookedTickets.get(racPassengerId);
			int lower=middleBerthsPositions.get(0);
			availableMiddleBerths--;
			String[] racPosition=racPassenger.getAllottedSeat().split("-");
			racPassenger.setAllottedSeat(String.valueOf(lower)+"-"+"M");
			racPassenger.setTicketStatus((byte)0);
			racPositions.add(Integer.valueOf(racPosition[0]));
			Collections.sort(racPositions);
			availableRacTickets++;
			updateWL();
		}
	}
	public void restoreUpperSeat(int seatNumber) {
		availableUpperBerths++;
		upperBerthsPositions.add(seatNumber);
		Collections.sort(upperBerthsPositions);
		if(!racList.isEmpty())
		{
			int racPassengerId=racList.poll();
			Passenger racPassenger=bookedTickets.get(racPassengerId);
			int lower=upperBerthsPositions.get(0);
			availableUpperBerths--;
			String[] racPosition=racPassenger.getAllottedSeat().split("-");
			racPassenger.setAllottedSeat(String.valueOf(lower)+"-"+"U");
			racPassenger.setTicketStatus((byte)0);
			racPositions.add(Integer.valueOf(racPosition[0]));
			Collections.sort(racPositions);
			availableRacTickets++;
			updateWL();
		}
	}
	public void restoreRAC(Passenger p,int seatNumber)
	{
		availableRacTickets++;
		racPositions.add(seatNumber);
		Collections.sort(racPositions);
		racList.remove(p.getPassengerId());
		updateWL();
	}
	public void restoreWL(Passenger p,int seatNumber)
	{
		availableWaitingList++;
		waitingListPositions.add(seatNumber);
		Collections.sort(waitingListPositions);
		waitingList.remove(p.getPassengerId());
		updateWL();
	}
}
