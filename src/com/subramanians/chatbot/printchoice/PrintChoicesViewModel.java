package com.subramanians.chatbot.printchoice;

import java.util.List;
import java.util.Stack;
import com.subramanians.chatbot.dto.Options;
import com.subramanians.chatbot.repository.ChatBotRepository;

public class PrintChoicesViewModel {
	private PrintChoices printChoices;
	private Stack<Options> navigation=new Stack<Options>();
	public Options inital=new Options("0","0");

	
	public PrintChoicesViewModel(PrintChoices printChoices)
	{
		this.printChoices=printChoices;
		navigation.push(inital);
	}
	
	public void showChoices()
	{
		List<String> retrieved=ChatBotRepository.getInstance().getMenu(navigation.peek().getDepth(), navigation.peek().getChoice());
		printChoices.onSuccessMenuRetrieval(retrieved);
	}
	
	public void pushChoices(String choice)
	{
		if(choice.equals("0") || choice.equals("9"))
		{
			popChoices(choice);
		}
		else if(Integer.valueOf(navigation.peek().getDepth())==0 && (Integer.valueOf(choice)>=1 && Integer.valueOf(choice)<=2))
		{
			inital=new Options(String.valueOf(Integer.valueOf(navigation.peek().getDepth())+1),choice);
			navigation.push(inital);
			showChoices();
		}else if(Integer.valueOf(navigation.peek().getDepth())!=0 && Integer.valueOf(choice) >= 1 && Integer.valueOf(choice) < printChoices.retrieved.size()-1)
		{
			inital=new Options(String.valueOf(Integer.valueOf(navigation.peek().getDepth())+1),navigation.peek().getChoice()+"_"+choice);
			navigation.push(inital);
			showChoices();
		}
		else
		{
			printChoices.showError("Please Enter Valid Choice...");
			showChoices();
		}
	}
	
	public void popChoices(String choice)
	{
		if(!navigation.peek().getDepth().equals("0") && !choice.equals("0"))
		{
			navigation.pop();
			showChoices();
		}else if(choice.equals("0"))
		{
			printChoices.onExit("Thank You For Contacting us!!");
			System.exit(0);
		}
	}
}
