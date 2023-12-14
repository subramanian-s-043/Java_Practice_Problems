package com.subramanians.dsa;

import java.util.Scanner;

public class MaximumGap {
	public static void main(String[] args) {
		MaximumGap start=new MaximumGap();
		start.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of array: ");
		int size=scanner.nextInt();
		System.out.println("Enter the array as space-separated: ");
		int[] input=new int[size];
		for(int i=0;i<size;i++)
		{
			input[i]=scanner.nextInt();
		}
		sort(input);
		maximumGap(input);
		scanner.close();
	}
	private void maximumGap(int[] input)
	{
		int max=0;
		for(int i=0;i<input.length-1;i++)
		{
			if(input[i+1]-input[i] > max)
			{
				max=input[i+1]-input[i];
			}
		}
		System.out.println("Maximum Gap Between Array: "+max);
	}
	private void sort(int[] input)
	{
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input.length -i-1;j++)
			{
				if(input[i]>input[j])
				{
					int temp=input[i];
					input[i]=input[j];
					input[j]=temp;
				}
			}
		}
	}
}

