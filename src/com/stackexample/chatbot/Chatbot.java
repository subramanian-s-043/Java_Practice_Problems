package com.stackexample.chatbot;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Chatbot {
	Stack<Options> navigation=new Stack<Options>();
	
	public static void main(String[] args) {
		Chatbot obj=new Chatbot();
		obj.start();
	}
	
	public static class Options{
		private String  depth;
		private String choice;
		
		Options(String depth,String choice)
		{
			this.depth=depth;
			this.choice=choice;
		}
		public String getDepth() {
			return depth;
		}
		public void setDepth(String depth) {
			this.depth = depth;
		}
		public String getChoice() {
			return choice;
		}
		public void setChoice(String choice) {
			this.choice = choice;
		}
		
	}
	
	private void start() {
		System.out.println("===============================================");
		System.out.println("\t WELCOME TO ONLINE STORE \t");
		System.out.println("===============================================");
		String choice="0";
		Scanner sc=new Scanner(System.in);
		navigation.push(new Options("0","0"));
		print("0","0");
		do {
			System.out.println("Enter your Option: ");
			choice=sc.nextLine();
			if(choice.equals("0"))
			{
				break;
			}
			if(choice.equals("9"))
			{
				navigation.pop();
				if(navigation.isEmpty())
				{
					break;
				}
			}else {
				if(Integer.valueOf(navigation.peek().depth) < 1)
				{
					navigation.push(new Options(String.valueOf(Integer.valueOf(navigation.peek().depth) + 1),choice));
				}else {
					navigation.push(new Options(String.valueOf(Integer.valueOf(navigation.peek().depth) + 1),navigation.peek().choice+"_"+choice));
					
				}	
			}
			Options top=navigation.peek();
			print(top.depth,top.choice);
			
		}while(!choice.equals("0"));
		System.out.println("Thank You For Contacting Us!!");
	}
	private void print(String level,String choice)
	{
		for (String choiceString : getChoices(level, choice)) {
			System.out.println(choiceString);
		}
	}
	
	private ArrayList<String> getChoices(String level, String choice) {
		ArrayList<String> choiceList=new ArrayList<String>();
		JSONParser parser= new JSONParser();
		Object o;
		JSONObject jsonobj;
		try {
			o = parser.parse(new FileReader(new File(".").getCanonicalPath()+"\\src\\com\\stackexample\\chatbot\\StoreData.json"));
			jsonobj=(JSONObject) o;
			JSONObject name=(JSONObject) jsonobj.get(level);
			JSONArray arr=(JSONArray)name.get(choice);
			for(int i=0;i<arr.size();i++)
			{
				choiceList.add((String)arr.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return choiceList;
	}

}
