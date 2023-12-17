package com.subramanians.tablebooking;

import java.util.Scanner;

import com.subramanians.tablebooking.booktable.BookTableView;
import com.subramanians.tablebooking.canceltable.CancelView;
import com.subramanians.tablebooking.viewtable.ViewTable;

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
				BookTableView book=new BookTableView();
				book.getInput();
				break;
			case 2:
				ViewTable view=new ViewTable();
				view.getInput();
				break;
			case 3:
				CancelView cancel=new CancelView();
				cancel.getInput();
				break;
			case 4:
				run=false;
				scanner.close();
				break;
			}
		}
	}
}
