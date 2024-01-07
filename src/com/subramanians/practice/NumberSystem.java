package com.subramanians.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class NumberSystem {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Number to View: ");
		int input=scanner.nextInt();
		List<Integer> numbers=new ArrayList<>();
		Queue<Integer> numberSystem=new LinkedList<>();
		numberSystem.add(3);
		numberSystem.add(4);
		numbers.add(3);
		numbers.add(4);
		int t=2;
		if(input<2)
		{
			System.out.println(numbers.get(input-1));
			return;
		}
		while(t<=input)
		{
			int temp1=numberSystem.poll();
			int temp2=numberSystem.poll();
			numberSystem.add(Integer.valueOf(String.valueOf(temp1)+"3"));
			t++;
			numberSystem.add(Integer.valueOf(String.valueOf(temp1)+"4"));
			t++;
			numbers.add(Integer.valueOf(String.valueOf(temp1)+"3"));
			numbers.add(Integer.valueOf(String.valueOf(temp1)+"4"));
			numberSystem.add(Integer.valueOf(String.valueOf(temp2)+"3"));
			t++;
			numberSystem.add(Integer.valueOf(String.valueOf(temp2)+"4"));
			t++;
			numbers.add(Integer.valueOf(String.valueOf(temp2)+"3"));
			numbers.add(Integer.valueOf(String.valueOf(temp2)+"4"));
		}
		System.out.println(numbers.get(input-1));
	}
}
