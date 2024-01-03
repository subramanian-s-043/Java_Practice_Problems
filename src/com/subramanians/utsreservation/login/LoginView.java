package com.subramanians.utsreservation.login;

import java.util.Scanner;

public class LoginView {
	LoginViewModel loginViewModel;
	
	public LoginView()
	{
		loginViewModel=new LoginViewModel(this);
	}
	
	public void getInput()
	{
		Scanner scanner=new Scanner(System.in);
	}
}
