package com.subramanians.chatbot.printchoice;

import java.util.ArrayList;
import java.util.List;
import com.subramanians.chatbot.inputchoice.InputChoiceView;

public class PrintChoices {
	private PrintChoicesViewModel printChoicesViewModel;
	private InputChoiceView inpChoiceView=new InputChoiceView(this);
	List<String> retrieved=new ArrayList<String>();
	public PrintChoices()
	{
		printChoicesViewModel=new PrintChoicesViewModel(this);
	}
	
	public void getList()
	{
		System.out.println("====================================");
		System.out.println("\t WELCOME TO ONLINE STORE \t");
		System.out.println("====================================");
		printChoicesViewModel.showChoices();
		inpChoiceView.getInput();
	}
	
	public void onSuccessMenuRetrieval(List<String> menu)
	{
		retrieved=menu;
		for(int i=0;i<menu.size();i++)
		{
			System.out.println(menu.get(i));
		}
		System.out.println("====================================");
	}

	public void inputFromuser(String choice) 
	{
		if(choice!="9")
		{
			System.out.println("====================================");
			printChoicesViewModel.pushChoices(choice);
			inpChoiceView.getInput();
		}else
		{
			printChoicesViewModel.popChoices(choice);
			inpChoiceView.getInput();
		}
	}
	
	public void showError(String errorMsg)
	{
		System.out.println(errorMsg);
		inpChoiceView.getInput();
	}

	public void onExit(String greet) {
		System.out.println(greet);
	}
}
