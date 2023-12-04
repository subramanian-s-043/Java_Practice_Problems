package com.subramanians.trainreservationsystem.bookticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.subramanians.trainreservationsystem.dto.Passenger;
import com.subramanians.trainreservationsystem.repo.TrainReservationRepository;

public class BookTicketViewModel {
	private BookTicket bookTicket;
	private JSONArray retrieved;
	Stack<Passenger> bookedTickets;
	
	
    int availableLowerBerths = 0;//normally 21
    int availableMiddleBerths = 0;//normally 21
    int availableUpperBerths = 0;//normally 21
    int availableRacTickets = 0;//normally 18
    int availableWaitingList = 0;//normally 10

    Queue<Integer> waitingList = new LinkedList<>();//queue of WL passengers
    Queue<Integer> racList =  new LinkedList<>();//queu of RAC passengers
    List<Integer> bookedTicketList =  new ArrayList<>();//list of bookedticket passengers

    List<Integer> lowerBerthsPositions = new ArrayList<>();//normally 1,2,...21
    List<Integer> middleBerthsPositions = new ArrayList<>();//normally 1,2,...21
    List<Integer> upperBerthsPositions = new ArrayList<>();//normally 1,2,...21
    List<Integer> racPositions = new ArrayList<>();//normally 1,2,...18
    List<Integer> waitingListPositions = new ArrayList<>();//normally 1,2,...10

	
	
	public BookTicketViewModel(BookTicket bookTicket) {
		this.bookTicket=bookTicket;
		this.bookedTickets=TrainReservationRepository.getInstance().getBookedHistory();
	}

	public void showTrains(String date,String source,String destination) {
		retrieved = TrainReservationRepository.getInstance().getTrainDetails(date, source, destination);
		bookTicket.onSuccess(retrieved);
		return ;
	}

	public void bookTicket(int choice, Passenger p) {
		
	}

	public void getTrainavailability(int choice) {
		TrainReservationRepository.getInstance().getTrainavailabity((JSONObject) retrieved.get(choice-1));
		this.availableLowerBerths=TrainReservationRepository.getInstance().getLowerAvailability((JSONObject) retrieved.get(choice-1));
		for(int i=(21-availableLowerBerths);i<=21;i++)
		{
			if(i==0)
			{
				i++;
			}
			lowerBerthsPositions.add(i);
		}
		this.availableMiddleBerths=TrainReservationRepository.getInstance().getMiddleAvailability((JSONObject) retrieved.get(choice-1));
		this.availableUpperBerths=TrainReservationRepository.getInstance().getUpperAvailability((JSONObject) retrieved.get(choice-1));
		this.availableRacTickets=TrainReservationRepository.getInstance().getRac((JSONObject) retrieved.get(choice-1));
		this.availableWaitingList=TrainReservationRepository.getInstance().getWL((JSONObject) retrieved.get(choice-1));
	}
	
}
