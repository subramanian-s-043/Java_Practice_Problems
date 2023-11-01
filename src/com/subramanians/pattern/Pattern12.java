package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern12 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern12(n);
	}
	public static void Pattern12(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i==0 || j==n-1 || j==0 || i==n-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println(" ");
		}
	}
}
