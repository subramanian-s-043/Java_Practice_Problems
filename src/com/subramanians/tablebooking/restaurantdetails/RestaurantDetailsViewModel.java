package com.subramanians.tablebooking.restaurantdetails;

import com.subramanians.tablebooking.dto.Table;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

public class RestaurantDetailsViewModel {
	RestaurantDetailsView detailsView;
	RestarauntBookingRepo repo;
	Table current;
	
	public RestaurantDetailsViewModel(RestaurantDetailsView detailsView)
	{
		this.detailsView=detailsView;
		this.repo=RestarauntBookingRepo.getInstance();
	}

	public void showDetails() {
		current=repo.getDetails();
		System.out.println("===================================================================");
		detailsView.showMessage("Restaurant Name: "+current.getRestaurantName());
		detailsView.showMessage("Total Number Of Tables: "+current.getTotalNumberOfTable());
		detailsView.showMessage("Each Table Capacity: "+current.getTableCapacity());
		detailsView.showMessage("Available: "+ (current.getIsAvailable() ? "Active" : "In-Active" ));
		System.out.println("===================================================================");
	}

	public void setNewTable(int newTable) {
		current.setTableCapacity(newTable);
		repo.updateDetails(current);
	}
	public void setNewName(String name) {
		current.setRestaurantName(name);
		repo.updateDetails(current);
	}

	public void changeInactive() {
		if(current.getIsAvailable())
		{
			current.setIsAvailable(false);
		}else {
			detailsView.showMessage("Restaurant Was Already In-active!....");
		}
		repo.updateDetails(current);
	}

	public void changeActive() {
		if(!current.getIsAvailable())
		{
			current.setIsAvailable(true);
		}else {
			detailsView.showMessage("Restaurant Was Already Active!....");
		}
		repo.updateDetails(current);
	}
}
