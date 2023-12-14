package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationOfStrings {
	public static void main(String[] args) {
		CombinationOfStrings start=new CombinationOfStrings();
		start.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the String: ");
		String input=scanner.next();
		combinations(input);
		scanner.close();
	}
	List<List<String>> combinations=new ArrayList<>();
	List<String> curr=new ArrayList<>();
	private void combinations(String input)
	{
		findCombinations(0,input.toCharArray());
		System.out.println(combinations);
	}
	private void findCombinations(int i, char[] charArray) {
		if(i==charArray.length)
		{
			combinations.add(new ArrayList<String>(curr));
			return;
		}
		curr.add(String.valueOf(charArray[i]));
		findCombinations(i+1, charArray);
		curr.remove(curr.size()-1);
		findCombinations(i+1, charArray);
	}
}
