package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern8 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern8(n);
	}
	public static void Pattern8(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if((i<=j && i+j>=n-1)&&(i==j||i+j==n-1||j==n-1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
