package com.subramanians.rolehierarchy.login;

import java.util.Scanner;

import com.subramanians.rolehierarchy.ceo.RoleView;

public class LoginView {
	LoginViewModel loginViewModel;
	RoleView app=new RoleView();
	
	public LoginView() {
		loginViewModel=new LoginViewModel(this);
	}
	
	public void getInput() {
		Scanner scanner=new Scanner(System.in);
		if(app.isCeo)
		{
			System.out.println("Enter the root role name: ");
			String role=scanner.next();
			loginViewModel.switchRole(role);
		}else {
			getCeo();
		}
	}

	public void getCeo() {
		app.getCeo();
	}
	
	public void showCeo() {
		app.showOperations();
	}

	public void showError(String msg) {
		System.out.println(msg);
		
	}
}
