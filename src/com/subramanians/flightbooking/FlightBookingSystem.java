package com.subramanians.flightbooking;

import com.subramanians.flightbooking.options.OptionsView;
import com.subramanians.flightbooking.schedule.ScheduleView;

public class FlightBookingSystem {
	
	public static void main(String[] args) {
		FlightBookingSystem app =new FlightBookingSystem();
		app.start();
	}

	private void start() {
		ScheduleView app = new ScheduleView();
		app.getSchedule();
		OptionsView option = new OptionsView();
		option.showOptions();
	}
}
