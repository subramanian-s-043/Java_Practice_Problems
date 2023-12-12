package com.subramanians.trainreservationsystem;

import java.util.Scanner;

import com.subramanians.trainreservationsystem.bookticket.BookTicket;
import com.subramanians.trainreservationsystem.cancelticket.CancelTicket;
import com.subramanians.trainreservationsystem.viewticket.ViewTicket;

public class TrainReservationSystem {
	public static void main(String[] args) {
		TrainReservationSystem application=new TrainReservationSystem();
		application.start();
	}
	
	public void start()
	{
		System.out.println("************************************************");
		System.out.println("\t WELCOME TO RAILWAY RESERVATION \t");
		System.out.println("************************************************");		
		boolean isTerminated=true;
		while(isTerminated)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("1.Book Ticket\n2.View Ticket\n3.Cancel Ticket\n4.Exit");
			System.out.println("=======================================================");	
			System.out.println("Enter Your Choice: ");
			int input=scanner.nextInt();
			switch(input)
			{
				case 1:
					BookTicket book=new BookTicket();
					book.getDetails();
					break;
				case 2:
					ViewTicket view=new ViewTicket();
					view.getDetails();
					break;
				case 3:
					CancelTicket cancel=new CancelTicket();
					cancel.getDetails();
					break;
				case 4:
					System.out.println("Thank You For Visiting!!");
					scanner.close();
					isTerminated=false;
					break;
			}	
		}
	}
}
