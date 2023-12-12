package com.subramanians.trainreservationsystem.viewticket;

import java.util.Map;
import com.subramanians.trainreservationsystem.dto.Passenger;
import com.subramanians.trainreservationsystem.repo.TrainReservationRepository;

public class ViewTicketViewModel {
	ViewTicket viewTkt;
	TrainReservationRepository repo;
	
	public ViewTicketViewModel(ViewTicket viewtkt) {
		this.viewTkt=viewtkt;
		this.repo=TrainReservationRepository.getInstance();
	}
	public void fetchTicket(int pnr) {
		Map<Integer,Passenger> retrieved=repo.getBookedTickets();
		if(retrieved.containsKey(pnr))
		{
			viewTkt.onSuccess(retrieved.get(pnr));
		}else
		{
			viewTkt.showMsg("Enter Valid PNR");
		}
	}
}
