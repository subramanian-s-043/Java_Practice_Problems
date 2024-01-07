package com.subramanians.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecodeNumber {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Map<Integer,Character> alphabets=new HashMap<>();
		int t=0;
		alphabets.put(0, 'Z');
		for(int i=1;i<=25;i++)
		{
			alphabets.put(i,(char) ('A' + t++));
		}
		System.out.println("Enter the encoded number: ");
		int input=scanner.nextInt();
		String output="";
		while(input!=0)
		{
			output+=String.valueOf(alphabets.get(input%26));
			if(input==26)
			{
				break;
			}
			input/=26;
		}
		String temp="";
		for(int i=output.length()-1;i>=0;i--)
		{
			temp+=String.valueOf(output.charAt(i));
		}
		System.out.println(temp);
	}
}
