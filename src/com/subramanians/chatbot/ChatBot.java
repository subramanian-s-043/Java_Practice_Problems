package com.subramanians.chatbot;

import com.subramanians.chatbot.printchoice.PrintChoices;

public class ChatBot {

	public static void main(String[] args) {
		ChatBot application=new ChatBot();
		application.start();
	}
	
	public void start()
	{
		PrintChoices printchoices=new PrintChoices();
		printchoices.getList();
	}
}
