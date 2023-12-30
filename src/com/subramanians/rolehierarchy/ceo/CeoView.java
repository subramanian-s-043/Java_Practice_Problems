package com.subramanians.rolehierarchy.ceo;

import java.util.Scanner;

public class CeoView {
	CeoViewModel ceoViewModel;
	public boolean isCeo=false;
	
	public CeoView() {
		ceoViewModel=new CeoViewModel(this);
	}
	
	public void showOperations()
	{
		System.out.println();
	}

	public void getCeo() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the root role name: ");
		String ceo=scanner.next();
		ceoViewModel.setCeo(ceo);
	}
	
	public void showMessage(String msg) {
		System.out.println(msg);
	}
}
