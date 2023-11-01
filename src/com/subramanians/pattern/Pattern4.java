package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern4 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern4(n);
	}
	public static void Pattern4(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n*2;j++)
			{
				if((i==0 && j==n-1)|| i+j==n-1 || j-i==n-1 || i==n-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
