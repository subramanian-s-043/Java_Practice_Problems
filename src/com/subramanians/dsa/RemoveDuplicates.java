package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
	public static void main(String[] args) {
		RemoveDuplicates start=new RemoveDuplicates();
		start.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Size of List: ");
		int size=scanner.nextInt();
		List<Integer> input=new ArrayList<>();
		System.out.println("Enter the Value Of List space-separated: ");
		for(int i=0;i<size;i++)
		{
			input.add(scanner.nextInt());
		}
		removeduplicates(input);
		scanner.close();
	}
	private void removeduplicates(List<Integer> input)
	{
		Set<Integer> removed=new HashSet<Integer>();
		for(int i=0;i<input.size();i++)
		{
			removed.add(input.get(i));
		}
		System.out.println(removed.toString());
	}
}
