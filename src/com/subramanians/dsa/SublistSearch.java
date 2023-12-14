package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SublistSearch {
	public static void main(String[] args) {
		SublistSearch start=new SublistSearch();
		start.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		List<List<Integer>> listOfSublists=new ArrayList<>(); 
		System.out.println("Enter the number Of sublist to be added: ");
		int size=scanner.nextInt();
		System.out.println("Enter the Size of each sublist: ");
		int subListSize=scanner.nextInt();
		for(int i=0;i<size;i++)
		{
			List<Integer> subList=new ArrayList<>();
			System.out.println("Enter the subList"+(i+1)+" with space-separated values: ");
			for(int j=0;j<subListSize;j++)
			{
				subList.add(scanner.nextInt());
			}
			listOfSublists.add(subList);
		}
		System.out.println("Enter the Sublist to search (Space-Separated): ");
		List<Integer> search=new ArrayList<>();
		for(int i=0;i<subListSize;i++)
		{
			search.add(scanner.nextInt());
		}
		System.out.println(search(listOfSublists,search));
		scanner.close();
	}
	private boolean search(List<List<Integer>> listOfSublists,List<Integer> search)
	{
		for(List<Integer> sublist: listOfSublists)
		{
			if(sublist.containsAll(search))
			{
				return true;
			}
		}
		return false;
	}
}
