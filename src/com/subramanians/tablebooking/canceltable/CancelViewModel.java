package com.subramanians.tablebooking.canceltable;

import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

public class CancelViewModel {
	CancelView cancelView;
	RestarauntBookingRepo repo;
	public CancelViewModel(CancelView cancelView) {
		this.cancelView=cancelView;
		this.repo=RestarauntBookingRepo.getInstance();
	}
	public void cancelTable(int bookingId) {
		if(repo.cancelTable(bookingId)) {
			cancelView.printSucess("Table Cancelled Successfully");
		}else {
			cancelView.showError("Error In Cancelling Table");
		}
	}
	
}
