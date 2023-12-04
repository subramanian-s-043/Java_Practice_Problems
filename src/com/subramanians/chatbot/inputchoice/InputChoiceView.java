package com.subramanians.chatbot.inputchoice;

import java.util.Scanner;
import com.subramanians.chatbot.printchoice.PrintChoices;

public class InputChoiceView {
	Scanner scanner=new Scanner(System.in);
	private PrintChoices getData;
	
	public InputChoiceView(PrintChoices inpChoiceView)
	{
		this.getData=inpChoiceView;
	}

	public void getList() 
	{
		getData.getList();
	}
	
	public void getInput()
	{
		System.out.println("Enter your Choice:");
		String choice=scanner.nextLine();
		getData.inputFromuser(choice);
	}
}
