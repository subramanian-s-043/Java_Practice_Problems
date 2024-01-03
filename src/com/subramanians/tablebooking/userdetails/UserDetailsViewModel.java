package com.subramanians.tablebooking.userdetails;

import com.subramanians.tablebooking.dto.Customer;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;

public class UserDetailsViewModel {
	UserDetailsView detailsView;
	RestarauntBookingRepo repo;
	
	public UserDetailsViewModel(UserDetailsView detailsView)
	{
		this.detailsView=detailsView;
		this.repo=RestarauntBookingRepo.getInstance();
	}

	public void switchChoice(int choice) {
		switch(choice)
		{
		case 1:
			detailsView.editName();
			break;
		case 2:
			detailsView.changePassword();
			break;
		case 3:
			return;
		}
		
	}
	public void changeName(String name)
	{
		repo.getCurrentCustomer().setName(name);
		if(repo.updateCustomer())
		{
			detailsView.showMessage("Updation Successfull!!");
		}else {
			detailsView.showMessage("Error In Updating");
		}
	}

	public boolean validatePassword(String password) {
		if(repo.getCurrentCustomer().getPassword().equals(password))
		{
			detailsView.showMessage("Old Password!!");
			return true;
		}else if(password.length()<=4) {
			detailsView.showMessage("Password Length Must Be greater than 4");
			return true;
		}
		repo.getCurrentCustomer().setPassword(password);
		repo.updateCustomer();
		return false;
	}
}
