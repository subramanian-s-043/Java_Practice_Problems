package com.subramanians.tablebooking.canceltable;

import java.util.Scanner;

public class CancelView {
	CancelViewModel cancelViewModel;
	public CancelView() {
		this.cancelViewModel=new CancelViewModel(this);
	}
	public void getInput() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the booking Id: ");
		int bookingId=scanner.nextInt();
		cancelViewModel.cancelTable(bookingId);
	}
	public void printSucess(String msg) {
		System.out.println(msg);
	}
	public void showError(String msg) {
		System.out.println(msg);
	}
}
