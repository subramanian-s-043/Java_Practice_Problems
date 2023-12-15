package com.subramanians.tablebooking;

import java.util.Scanner;

public class RestaurantTableBooking {
	public static void main(String[] args) {
		RestaurantTableBooking app=new RestaurantTableBooking();
		app.start();
	}
	private void start()
	{
		boolean run=true;
		while(run)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println(" 1.Book Table\n 2.View Booked Table\n 3.Cancel Table\n 4.Exit ");
			System.out.println("Enter Your Choice: ");
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				//Book ticket
				break;
			case 2:
				//View Booked Table
				break;
			case 3:
				//Cancel Table
				break;
			case 4:
				run=false;
				scanner.close();
				break;
			}
		}
	}
}
