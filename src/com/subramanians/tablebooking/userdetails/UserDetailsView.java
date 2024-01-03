package com.subramanians.tablebooking.userdetails;

import java.util.Scanner;

public class UserDetailsView {
	UserDetailsViewModel detailsViewModel;
	
	public UserDetailsView()
	{
		detailsViewModel=new UserDetailsViewModel(this);
	}
	
	public void showOptions()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println(" 1.Edit name \n 2.Change Password \n 3.Back");
		int choice=scanner.nextInt();
		detailsViewModel.switchChoice(choice);
	}
	
	public void editName()
	{
		Scanner scanner=new Scanner(System.in);
		String name;
		System.out.println("Enter the New Name: ");
		name=scanner.nextLine();
		detailsViewModel.changeName(name);
		
	}

	public void showMessage(String msg) {
		System.out.println(msg);
		
	}

	public void changePassword() {
		Scanner scanner=new Scanner(System.in);
		String password;
		do {
			System.out.println("Enter the New Name: ");
			password=scanner.nextLine();
		}while(detailsViewModel.validatePassword(password));
		detailsViewModel.changeName(password);	
	}
}
