package com.subramanians.tablebooking.canceltable;

import java.util.Scanner;

import com.subramanians.tablebooking.Utility;
import com.subramanians.tablebooking.dto.Booking;

public class CancelView {
	CancelViewModel cancelViewModel;
	public CancelView() {
		this.cancelViewModel=new CancelViewModel(this);
	}
	public void getInput() {
		cancelViewModel.showHistory();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the booking Id: ");
		int bookingId=scanner.nextInt();
		cancelViewModel.cancelTable(bookingId);
	}
	
	public void printSuccess(Booking c) {
		System.out.println("====================================");
		System.out.println("Booking Id: "+Utility.BLUE+c.getBookingId()+Utility.RESET);
		System.out.println("Booked Restaurant: "+Utility.BLUE+c.getbookedRestaurant()+Utility.RESET);
		System.out.println("Booked Customer Name: "+Utility.BLUE+c.getCustomerName()+Utility.RESET);
		System.out.println("Booked Date: "+Utility.RED+c.getDate()+Utility.RESET);
		System.out.println("Booked Time: "+Utility.RED+c.getTime()+Utility.RESET);
		System.out.println("Number Of People: "+Utility.BLUE+c.getnumberOfPeoples()+Utility.RESET);
		System.out.println("======================================");
	}
	
	public void showError(String msg) {
		System.out.println(msg);
	}
	public void printSucess(String msg) {
		System.out.println(msg);
		
	}
}
