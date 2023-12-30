package com.subramanians.rolehierarchy;

import com.subramanians.rolehierarchy.login.LoginView;

public class RoleHierarchy {
	public static void main(String[] args) {
		RoleHierarchy app=new RoleHierarchy();
		app.start();
	}
	
	private void start() {
		LoginView app=new LoginView();
		app.getInput();
	}
}
