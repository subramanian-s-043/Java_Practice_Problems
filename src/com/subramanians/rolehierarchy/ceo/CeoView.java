package com.subramanians.rolehierarchy.ceo;

import java.util.Scanner;

public class CeoView {
	CeoViewModel ceoViewModel;
	Scanner scanner=new Scanner(System.in);
	public boolean isCeo=false;
	
	public CeoView() {
		ceoViewModel=new CeoViewModel(this);
	}
	
	public void showOperations()
	{
		boolean run=true;
		System.out.println("Operations: ");
		while(run)
		{
			System.out.println("1. Add Sub Roles \n 0.Exit ");
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the sub-Role name: ");
				String subRole=scanner.next();
				System.out.println("Enter the Repoting to Role name: ");
				String reportingTo;
				do {
					reportingTo=scanner.next();
				}while(ceoViewModel.validateReportingTo(reportingTo));
				ceoViewModel.setSubRole(subRole,reportingTo);
				break;
			case 0:
				ceoViewModel.showReportingStaffs();
				run=false;
				break;
			}
		}
	}

	public void getCeo() {
		System.out.println("Enter the root role name: ");
		String ceo=scanner.next();
		ceoViewModel.setCeo(ceo);
	}
	
	public void showMessage(String msg) {
		System.out.println(msg);
	}
}
