package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern11 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern11(n);
	}
	public static void Pattern11(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
}
