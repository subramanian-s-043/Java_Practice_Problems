package com.subramanians.tablebooking.canceltable;

import java.util.List;

import com.subramanians.tablebooking.dto.Booking;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

public class CancelViewModel {
	CancelView cancelView;
	RestarauntBookingRepo repo;
	List<Booking> temp;
	
	public CancelViewModel(CancelView cancelView) {
		this.cancelView=cancelView;
		this.repo=RestarauntBookingRepo.getInstance();
	}
	
	public void showHistory() {
		temp=repo.getCurrentCustomer().getBookingHistory();
		for(int i=0;i<temp.size();i++)
		{
			cancelView.printSuccess(temp.get(i));	
		}
	}
	
	public void cancelTable(int bookingId) {
		for(int i=0;i<temp.size();i++)
		{
			if(temp.get(i).getBookingId()==bookingId)
			{
				if(repo.cancelTable(bookingId)) {
					cancelView.printSucess("Table Cancelled Successfully");
					return;
				}
			}else if(i==temp.size()-1) {
				cancelView.showError("Invalid Booking Id / Booking Id is Past");
			}
		}
	}
	
}
