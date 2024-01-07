package com.subramanians.practice;

import java.util.Scanner;

public class MoveZerosLast {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size: ");
		int size=scanner.nextInt();
		int[] inputArray=new int[size];
		int j=size-1;
		for(int i=0;i<size;i++)
		{
			System.out.println("Enter the element"+ (i+1)+" : ");
			inputArray[i]=scanner.nextInt();
		}
		for(int i=0;i<size/2;i++)
		{
			if(inputArray[i]==0)
			{
				if(inputArray[j]!=0)
				{
					inputArray[i]=inputArray[j];
					inputArray[j]=0;
					j--;
				}else {
					while(inputArray[j]==0)
					{
						j--;
					}
					inputArray[i]=inputArray[j];
					inputArray[j]=0;
				}
			}
		}
		for(int a:inputArray)
		{
			System.out.print(a+" ");
		}
	}
}
