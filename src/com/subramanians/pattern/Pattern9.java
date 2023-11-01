package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern9 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern9(n);
	}
	public static void Pattern9(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if((i+j>=n-1 && i>=j)&&(i==j || i+j==n-1 || j==n-1))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if((i<=j && i+j<=n-1) && (i==j || i+j==n-1 || j==0))
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
