package com.subramanians.tablebooking.login;
import com.subramanians.tablebooking.booktable.BookTableView;
import com.subramanians.tablebooking.canceltable.CancelView;
import com.subramanians.tablebooking.repository.RestarauntBookingRepo;
import com.subramanians.tablebooking.restaurantdetails.RestaurantDetailsView;
import com.subramanians.tablebooking.userdetails.UserDetailsView;
import com.subramanians.tablebooking.viewtable.ViewTable;

public class LoginViewModel {
	LoginView loginView;
	RestarauntBookingRepo repo;
	RestaurantDetailsView update;
	public LoginViewModel(LoginView loginView)
	{
		this.loginView=loginView;
		this.repo=RestarauntBookingRepo.getInstance();
	}
	
	public void start(int choice)
	{
		switch(choice)
		{
		case 1:
			BookTableView book=new BookTableView();
			book.getInput();
			break;
		case 2:
			ViewTable view=new ViewTable();
			view.getInput();
			break;
		case 3:
			CancelView cancel=new CancelView();
			cancel.getInput();
			break;
		case 4:
			UserDetailsView edit=new UserDetailsView();
			edit.showOptions();
			break;
		case 5:
			loginView.isLogged=false;
			break;
		}
	}

	public void setUser(int choice) {
		if(choice==1)
		{
			loginView.user();
		}else if(choice==2) {
			loginView.admin();
		}else {
			loginView.run=false;
			return;
		}
		
	}

	public void validateAdmin(String username, String password) {
		if(repo.isValidAdmin(username,password))
		{
			loginView.isLogged=true;
			loginView.restaurantName=repo.restaurantName;
			return;
		}else {
			loginView.showError("Invalid Username/Password!!");
			return;
		}
		
	}

	public void adminStart(int choice) {
		update=new RestaurantDetailsView();
		switch(choice)
		{
		case 1:
			update.showUpdate();
			break;
		case 2:
			update.viewDetails();
			break;
		case 4:
			loginView.isLogged=false;
			break;
		}
		
	}

	public void validateUser(String username, String password) {
		if(repo.isValidUser(username, password))
		{
			loginView.isLogged=true;
			loginView.showMessage("===================================================");
			loginView.showMessage("             Login Successfull ! ! !....           ");
			loginView.showMessage("===================================================");
			return;
		}else {
			loginView.showError("Invalid Username/Password!!");
		}
	}

	public void createUser(String username, String password, String name) {
		if(repo.createUser(username,password,name))
		{
			loginView.showMessage("Account Created Successfully, Login to Book!!");
			return;
		}else {
			loginView.showError("Error In Creating Account!");
		}
		
	}

	public void switchUser(int choice) {
		if(choice==1)
		{
			loginView.existingUser();
		}else if(choice==2) {
			loginView.newUser();
		}else {
			loginView.showError("Invalid Input");
			return;
		}
		
	}

	public boolean validateUsername(String username) {
		if(username.split(" ").length>1) {
			loginView.showError("Username should not contain more than one word!!");
			return true;
		}
		if(repo.validateUsername(username))
		{
			loginView.showError("User Already Exists!!");
			return true;
		}
		return false;
	}

	public boolean validatePassword(String password) {
		if(password.length()<=4)
		{
			loginView.showError("Password Must Be length more than 4!!");
			return true;
		}
		return false;
	}
}
