package com.subramanians.dsa;

import java.util.Scanner;

public class WordFrequency {
	public void getInput()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Paragaraph: ");
		String input=sc.nextLine();
		String output=findFrequency(input);
		System.out.println(output);
	}
	private String findFrequency(String input) 
	{
		String[] inputArray=input.toLowerCase().split(" ");
		String output="";
		for(int i=0;i<inputArray.length;i++)
		{
			String temp=inputArray[i];
			if(!output.contains(temp))
			{
				if(temp.length()==1 && !Character.isAlphabetic(temp.charAt(0)))
				{
					continue;
				}else {
				int freq=0;
				for(int j=0;j<inputArray.length;j++)
				{
					if(temp.equals(inputArray[j]))
					{
						freq++;
					}
				}
				if(output=="")
				{
					output+=temp+"-"+String.valueOf(freq);
				}else
				{
					output+=","+temp+"-"+String.valueOf(freq);
				}
			}
			}
		}
		return output;
	}
	public static void main(String[] args) 
	{
		WordFrequency start=new WordFrequency();
		start.getInput();
	}
}
