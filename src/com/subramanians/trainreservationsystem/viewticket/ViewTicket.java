package com.subramanians.trainreservationsystem.viewticket;

import java.util.Scanner;
import com.subramanians.trainreservationsystem.dto.Passenger;

public class ViewTicket {
	ViewTicketViewModel viewTktModel;
	
	public ViewTicket()
	{
		this.viewTktModel=new ViewTicketViewModel(this);
	}
	
	public void getDetails()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the PNR Number: ");
		int pnr=scanner.nextInt();
		viewTktModel.fetchTicket(pnr);
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
		return ;
	}
	
	public void showMsg(String msg)
	{
		System.out.println(msg);
	}
}
