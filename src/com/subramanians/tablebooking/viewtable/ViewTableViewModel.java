package com.subramanians.tablebooking.viewtable;

import com.subramanians.tablebooking.dto.Customer;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

public class ViewTableViewModel {
		ViewTable viewTable;
		RestarauntBookingRepo repo;
		public ViewTableViewModel(ViewTable viewTable) {
			this.viewTable=viewTable;
			this.repo=RestarauntBookingRepo.getInstance();
		}
		public void getCustomer(int bookingId) {
			Customer c=repo.getCustomer(bookingId);
			if(c.getBookingId()==0) {
				viewTable.showError("Invalid Booking Id");
			}else if(c.getBookingId()!=bookingId) {
				viewTable.showError("Enter Valid Booking Id");
			}else {
				viewTable.printSuccess(c);
			}
		}
}
