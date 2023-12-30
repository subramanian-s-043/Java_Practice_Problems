package com.subramanians.rolehierarchy.login;

public class LoginViewModel {
	LoginView loginView;
	
	public LoginViewModel(LoginView loginView)
	{
		this.loginView=loginView;
	}
	
	public void switchRole(String role)
	{
		switch(role)
		{
		case "CEO" :
			loginView.showCeo();
			break;
		default :
			loginView.showError("Enter Valid Role");
		}
	}
}
