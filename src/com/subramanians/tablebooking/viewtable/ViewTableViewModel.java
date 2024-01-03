package com.subramanians.tablebooking.viewtable;

import java.util.List;

import com.subramanians.tablebooking.dto.Booking;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

public class ViewTableViewModel {
		ViewTable viewTable;
		RestarauntBookingRepo repo;
		
		public ViewTableViewModel(ViewTable viewTable) {
			this.viewTable=viewTable;
			this.repo=RestarauntBookingRepo.getInstance();
		}
		
		public void getCustomer() {
			List<Booking> temp=repo.getCurrentCustomer().getBookingHistory();
			for(int i=0;i<temp.size();i++)
			{
				viewTable.printSuccess(temp.get(i));	
			}
		}
}
