package com.subramanians.tablebooking.login;

import java.util.Scanner;

import com.subramanians.tablebooking.Utility;

public class LoginView {
	LoginViewModel loginViewModel;
	boolean run=true;
	boolean isLogged=false;
	public String restaurantName;
	public LoginView() {
		loginViewModel=new LoginViewModel(this);
	}
	
	public void getInput()
	{
		while(run)
		{
			Scanner scanner=new Scanner(System.in);
	        System.out.println("+-----------------------------------------------------------------+");
	        System.out.println("|                                                                 |");
	        System.out.println("|             Welcome to Restaurant Table Booking                 |");
	        System.out.println("|                                                                 |");
	        System.out.println("+-----------------------------------------------------------------+");
	        System.out.println(" 1. User");
	        System.out.println(" 2. Admin");
	        System.out.println(" 3. Exit");
	        System.out.println("===================================================================");
	        System.out.println("Enter Your Choice: ");
			int choice=scanner.nextInt();
			loginViewModel.setUser(choice);
		}
	}
	public void newUser()
	{
		Scanner scanner=new Scanner(System.in);
		String username;
		do {
			System.out.println("Enter your Username: ");
			username=scanner.nextLine();
		}while(loginViewModel.validateUsername(username));
		String password;
		do {
			System.out.println("Enter your Password: ");
			password=scanner.next();
		}while(loginViewModel.validatePassword(password));
		System.out.println("Enter Your Name: ");
		String name=scanner.next();
		loginViewModel.createUser(username,password,name);
	}
	
	public void existingUser()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your Username: ");
		String username=scanner.next();
		System.out.println("Enter your Password: ");
		String password=scanner.next();
		loginViewModel.validateUser(username,password);
		showUser();
	}
	
	private void showUser()
	{
		while(isLogged)
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println(" 1.Book Table\n 2.View Booked History\n 3.Cancel Table\n 4.Edit User-details \n 5.logout ");
			System.out.println("===================================================================");
			System.out.println("Enter Your Choice: ");
			int choice=scanner.nextInt();
			loginViewModel.start(choice);
		}
	}
	
	public void admin()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your Username: ");
		String username=scanner.next();
		System.out.println("Enter your Password: ");
		String password=scanner.next();
		loginViewModel.validateAdmin(username,password);
		showAdmin();
	}

	private void showAdmin() {
		while(isLogged)
		{
			Scanner scanner=new Scanner(System.in);
	        System.out.println("+-----------------------------------------------------------------+");
	        System.out.println("|                                                                 |");
	        System.out.println("|             " + restaurantName + " Admin DashBoard              |");
	        System.out.println("|                                                                 |");
	        System.out.println("+-----------------------------------------------------------------+");
			System.out.println(" 1.Update Restaurant Details \n 2.View Restaurant Details \n 4.Logout ");
			System.out.println("===================================================================");
			System.out.println("Enter Your Choice: ");
			int choice=scanner.nextInt();
			loginViewModel.adminStart(choice);
		}
	}
	
	public void showMessage(String msg)
	{
		System.out.println(msg);
	}

	public void user() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("===========================================================");
		System.out.println(" 1.Login (Existing User) \n 2.Sign-in (New User) \n 0.Back ");
		System.out.println("===========================================================");
		System.out.println("Enter your choice: ");
		int choice=scanner.nextInt();
		loginViewModel.switchUser(choice);
	}
	
	public void showError(String msg)
	{
		System.out.println(Utility.RED+msg+Utility.RESET);
	}
}
