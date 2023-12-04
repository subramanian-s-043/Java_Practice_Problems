package com.subramanians.trainreservationsystem;

import java.util.Scanner;

import com.subramanians.trainreservationsystem.bookticket.BookTicket;

public class TrainReservationSystem {
	public static void main(String[] args) {
		TrainReservationSystem application=new TrainReservationSystem();
		application.start();
	}
	
	public void start()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println(" 1.Book Ticket\n 2.View Ticket\n 3.Cancel Ticket\n 4.Exit");
		int input=scanner.nextInt();
		switch(input)
		{
			case 1:
				BookTicket start=new BookTicket();
				start.getDetails();
				
				break;
			case 2:
				//View Ticket
				break;
			case 3:
				//Cancel Ticket
				break;
			case 4:
				System.out.println("Thank You For Visiting!!");
				break;
		}
	}
}
