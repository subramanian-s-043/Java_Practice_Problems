package com.subramanians.tablebooking.booktable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.subramanians.tablebooking.Utility;
import com.subramanians.tablebooking.dto.Customer;
import com.subramanians.tablebooking.dto.Table;

public class BookTableView {
	BookTableViewModel bookTableViewModel;
	
	public BookTableView(){
		bookTableViewModel=new BookTableViewModel(this);
	}
	
	//Get Necessary Input
	
	public void getInput() {
		printDates();
		System.out.println(Utility.CYAN+"=================================================="+Utility.RESET);
		Scanner scanner=new Scanner(System.in);
		System.out.println("Choose the date to see the available Restaurants: ");
		int option=scanner.nextInt();
		bookTableViewModel.retrieveRestaurant(option);
		System.out.println("Choose the Restaurant to Book: ");
		option=scanner.nextInt();
		bookTableViewModel.retrieveAvailability(option);
		System.out.println("Choose The Time you want to Book: ");
		option=scanner.nextInt();
		bookTableViewModel.setTime(option);
		System.out.println("Enter the Name: ");
		String name;
		do {
			name=scanner.next();
		}while(!bookTableViewModel.validateName(name));
		System.out.println("Number Of People(Max 4 people per booking): ");
		int numberOfPeople;
		do {
			numberOfPeople=scanner.nextInt();
		}while(bookTableViewModel.validateNumberOfPeople(numberOfPeople));
		bookTableViewModel.book(name, numberOfPeople);
	}
	
	//Print Valid Dates
	
	public void printDates() {
		int option=1;
		for(LocalDate date:bookTableViewModel.generateDates())
		{
			System.out.println((option++)+"->"+date);
		}
	}
	
	//Print Available Restaurants
	
	public void printResutaurants(List<Table> retrieved) {
		int option=1;
		for(Table t: retrieved)
		{
			System.out.println((option++)+"->Restaurant Name: "+t.getRestaurantName());
			System.out.println("Total Number Of Tables: "+t.getTotalNumberOfTable());
			System.out.println("Each Table Capacity: "+t.getTableCapacity());
			System.out.println(Utility.ROSECOLOR+"==================================================="+Utility.RESET);
		}
	}
	
	//Print Available Timings
	
	public void printAvailableTime(List<LocalTime> availableTime) {
		int option=1;
		System.out.println(Utility.GREEN+"Available Timings: "+Utility.RESET);
		System.out.println(Utility.YELLOW+"Break-Fast"+Utility.RESET);
		for(LocalTime t:availableTime) {
			if(t.isAfter(LocalTime.of(8, 0)) &&t.isBefore(LocalTime.of(11, 0)))
			System.out.println((option++)+"->"+t);
		}
		System.out.println(Utility.ROSECOLOR+"==================================================="+Utility.RESET);
		System.out.println(Utility.YELLOW+"Lunch"+Utility.RESET);
		for(LocalTime t:availableTime) {
			if(t.isAfter(LocalTime.of(11, 30)) && t.isBefore(LocalTime.of(16, 0)))
			System.out.println((option++)+"->"+t);
		}
		System.out.println(Utility.ROSECOLOR+"==================================================="+Utility.RESET);
		System.out.println(Utility.YELLOW+"Dinner"+Utility.RESET);
		for(LocalTime t:availableTime) {
			if(t.isAfter(LocalTime.of(18, 30)) && t.isBefore(LocalTime.of(22, 0)))
			System.out.println((option++)+"->"+t);
		}
	}
	
	//Print Booking Success
	
	public void printSuccess(Customer c) {
		System.out.println("====================================");
		System.out.println("Booking Id: "+Utility.ORANGE+c.getBookingId()+Utility.RESET);
		System.out.println("Booked Restaurant: "+Utility.ORANGE+c.getbookedRestaurant()+Utility.RESET);
		System.out.println("Booked Customer Name: "+Utility.ORANGE+c.getCustomerName()+Utility.RESET);
		System.out.println("Booked Date: "+Utility.RED+c.getDate()+Utility.RESET);
		System.out.println("Booked Time: "+Utility.RED+c.getTime()+Utility.RESET);
		System.out.println("Number Of People: "+Utility.BLUE+c.getnumberOfPeoples()+Utility.RESET);
		System.out.println("======================================");
	}
	
	//Print Error Message
	
	public void showError(String msg) {
		System.out.println(Utility.RED+msg+Utility.RESET);
	}
}
