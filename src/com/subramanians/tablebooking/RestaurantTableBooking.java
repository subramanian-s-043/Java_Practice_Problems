package com.subramanians.tablebooking;

import com.subramanians.tablebooking.login.LoginView;

public class RestaurantTableBooking {
	public static void main(String[] args) {
		RestaurantTableBooking app=new RestaurantTableBooking();
		app.start();
	}
	private void start()
	{
		LoginView start=new LoginView();
		start.getInput();
	}
}
