package com.subramanians.trainreservationsystem.cancelticket;

import java.util.Map;

import com.subramanians.trainreservationsystem.dto.Passenger;
import com.subramanians.trainreservationsystem.repo.TrainReservationRepository;

public class CancelTicketViewModel {
	CancelTicket cancelTkt;
	TrainReservationRepository repo;
	Map<Integer,Passenger> retrieved;
	Passenger ticket;
	
	public CancelTicketViewModel(CancelTicket cancelTkt) {
		this.cancelTkt=cancelTkt;
		this.repo=TrainReservationRepository.getInstance();
	}

	public void viewTicket(int pnr) {
		retrieved=repo.getBookedTickets();
		if(retrieved.containsKey(pnr))
		{
			ticket=retrieved.get(pnr);
			cancelTkt.onSuccess(ticket);
		}else
		{
			cancelTkt.showMsg("Invalid PNR!!");
		}
	}
	public void cancelTicket()
	{
		String[] seatAndBerthNumber=ticket.getAllottedSeat().split("-");
		System.out.println(seatAndBerthNumber[0]+" "+seatAndBerthNumber[1]);
		if(seatAndBerthNumber[1].equals("L"))
		{
			repo.restoreLowerSeat(Integer.valueOf(seatAndBerthNumber[0]));
		}else if(seatAndBerthNumber[1].equals("M"))
		{
			repo.restoreMiddleSeat(Integer.valueOf(seatAndBerthNumber[0]));
		}else if(seatAndBerthNumber[1].equals("U"))
		{
			repo.restoreUpperSeat(Integer.valueOf(seatAndBerthNumber[0]));
		}else if(seatAndBerthNumber[1].equals("RAC"))
		{
			repo.restoreRAC(ticket,Integer.valueOf(seatAndBerthNumber[0]));
		}else if(seatAndBerthNumber[1].equals("WL"))
		{
			repo.restoreWL(ticket, Integer.valueOf(seatAndBerthNumber[0]));
		}
	}
}
