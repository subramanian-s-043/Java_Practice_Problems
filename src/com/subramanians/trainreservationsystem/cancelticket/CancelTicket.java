package com.subramanians.trainreservationsystem.cancelticket;

import java.util.Scanner;
import com.subramanians.trainreservationsystem.dto.Passenger;

public class CancelTicket {
	CancelTicketViewModel cancelTktModel;
	
	public CancelTicket()
	{
		this.cancelTktModel=new CancelTicketViewModel(this);
	}
	
	public void getDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the PNR Number : ");
		int pnr=scanner.nextInt();
		cancelTktModel.viewTicket(pnr);
	}
	
	public void onSuccess(Passenger p)
	{
		String sts="";
		if(p.getTicketStatus()==0)
		{
			sts="CNF";
		}else if(p.getTicketStatus()==1)
		{
			sts="RAC";
		}else
		{
			sts="WL";
		}
		System.out.println("PNR : "+p.getPassengerId());
		System.out.println("Train No: "+p.getTrainNo());
		System.out.println("Ticket Status: "+sts);
		System.out.println("Passenger Name: "+p.getPassengerName());
		System.out.println("Seat Number: "+p.getAllottedSeat());
		Scanner scanner=new Scanner(System.in);
		System.out.println("Press Y to cancel Ticket: ");
		char confirm=scanner.next().charAt(0);
		if(confirm=='Y' || confirm=='y')
		{
			cancelTktModel.cancelTicket();
		}else
		{
			return;
		}
	}
	
	public void showMsg(String msg)
	{
		System.out.println(msg);
	}
}
