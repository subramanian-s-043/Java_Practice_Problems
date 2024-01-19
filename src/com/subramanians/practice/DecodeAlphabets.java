package com.subramanians.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DecodeAlphabets {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
//		Map<Character,Integer> alphabets=new HashMap<>();
//		int t=0;
//		for(int i=1;i<=26;i++)
//		{
//			alphabets.put((char) ('A' + t++), i);
//		}
		System.out.println("Enter the Encoded Alphabets: ");
		String input=scanner.nextLine();
		int decodedValue=0;
		int place=0;
		for(int i=input.length()-1;i>=0;i--)
		{
			decodedValue+=((int)input.charAt(i)- 64)*Math.pow(26, place++);
		}
		System.out.println(decodedValue);
	}
}
