package com.subramanians.trainreservationsystem.repo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	private JSONObject retrievedTrainDetails;
	private JSONObject retrievedStationCode;
	private JSONObject retrievedAvailability;
	private JSONObject avail;
	Stack<Passenger> bookedTickets=new Stack<>();
	
	public TrainReservationRepository()
	{
		try {
			readTrainDetails=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainDetails.json"));
			retrievedTrainDetails=(JSONObject) readTrainDetails;
			readStationCode=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainStationCode.json"));
			retrievedStationCode=(JSONObject) readStationCode;
		} catch (IOException | ParseException e) {
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
	public Stack getBookedHistory()
	{
		return bookedTickets;
	}
	public JSONArray getTrainDetails(String date,String source,String destination)
	{
		String stationCode=(String) retrievedStationCode.get(source.replace(" ", "").toUpperCase())+"_"+retrievedStationCode.get(destination.replace(" ", "").toUpperCase());
		JSONArray retrieved= (JSONArray) retrievedTrainDetails.get(stationCode);
		
		return retrieved;
	}

	public void getTrainavailabity(JSONObject trainIndex) {
		trainIndex.get("TrainNo");
		
	}

	public int getLowerAvailability(JSONObject trainIndex) {
		try {
			readAvailability=parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\subramanians\\trainreservationsystem\\TrainAvailability.json"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		retrievedAvailability=(JSONObject) readAvailability;
		avail=(JSONObject) retrievedAvailability.get(trainIndex.get("TrainNo"));
		int lower=Integer.valueOf((String) avail.get("availableLowerBerth"));
		return lower;
	}
	
	public int getUpperAvailability(JSONObject trainIndex) {
		int upper=Integer.valueOf((String) avail.get("availableUpperBerth"));
		return upper;
	}
	
	public int getMiddleAvailability(JSONObject trainIndex) {
		int middle=Integer.valueOf((String) avail.get("availableMiddleBerth"));
		return middle;
	}
	
	public int getRac(JSONObject trainIndex) {
		int RAC=Integer.valueOf((String) avail.get("availableRac"));
		return RAC;
	}
	
	public int getWL(JSONObject trainIndex) {
		int WL=Integer.valueOf((String) avail.get("availableWL"));
		return WL;
	}
}
