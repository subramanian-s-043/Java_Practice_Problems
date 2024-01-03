package com.subramanians.tablebooking.restaurantdetails;

import java.util.Scanner;

public class RestaurantDetailsView {
	RestaurantDetailsViewModel detailsViewModel;
		
	public RestaurantDetailsView()
	{
		this.detailsViewModel=new RestaurantDetailsViewModel(this);
	}
	
	public void showUpdate()
	{
		detailsViewModel.showDetails();
		Scanner scanner=new Scanner(System.in);
		System.out.println("===================================================================");
		System.out.println(" 1.Update Table Details \n 2.Update Restaurant Name \n 3.Change Status to In-active \n 4.Change Status to Active  \n 5.Back");
		System.out.println("===================================================================");
		System.out.println("Enter Your Choice: ");
		int choice=scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the New Table Value: ");
			int newTable=scanner.nextInt();
			detailsViewModel.setNewTable(newTable);
			break;
		case 2:
			System.out.println("Enter the New Name for Restaurant: ");
			String newName=scanner.nextLine();
			detailsViewModel.setNewName(newName);
			break;
		case 3:
			detailsViewModel.changeInactive();
			break;
		case 4:
			detailsViewModel.changeActive();
			break;
		case 5:
			return;
		}
	}
	
	public void showMessage(String msg)
	{
		System.out.println(msg);
	}

	public void viewDetails() {
		detailsViewModel.showDetails();
	}
}
