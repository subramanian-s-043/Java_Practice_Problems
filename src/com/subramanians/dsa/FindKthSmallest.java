package com.subramanians.dsa;

import java.util.Scanner;

public class FindKthSmallest {
	public static void main(String[] args) {
		FindKthSmallest start=new FindKthSmallest();
		start.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of List: ");
		int size=scanner.nextInt();
		int[] input=new int[size];
		System.out.println("Enter the elements as space-separated: ");
		for(int i=0;i<size;i++)
		{
			input[i]=scanner.nextInt();
		}
		System.out.println("Enter the K: ");
		int k=scanner.nextInt();
		kthSmallest(input,k);
		scanner.close();
	}
	private void kthSmallest(int[] input,int k)
	{
		for(int i=0;i<input.length;i++)
		{
			for(int j=0;j<input.length-i-1;j++)
			{
				if(input[i] > input[j+1])
				{
					int temp=input[i];
					input[i]=input[j+1];
					input[j+1]=temp;
				}
			}
		}
		System.out.println(input[k-1]);
	}
}
