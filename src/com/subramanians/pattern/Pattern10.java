package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern10 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern10(n);
	}
	public static void Pattern10(int n)
	{
		int c=n/2;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
					System.out.print("*");
			}
			System.out.println("");
		}
	}
}
