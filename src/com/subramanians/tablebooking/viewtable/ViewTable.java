package com.subramanians.tablebooking.viewtable;

import java.util.Scanner;

import com.subramanians.tablebooking.Utility;
import com.subramanians.tablebooking.dto.Booking;

public class ViewTable {
	ViewTableViewModel viewTableviewmodel;
	
	public ViewTable() {
		this.viewTableviewmodel=new ViewTableViewModel(this);
	}
	
	public void getInput() {
//		Scanner scanner=new Scanner(System.in);
//		System.out.println("Enter the Booking Id: ");
//		int input=scanner.nextInt();
		viewTableviewmodel.getCustomer();
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
		System.out.println(Utility.RED+ msg + Utility.RESET);
	}
}
