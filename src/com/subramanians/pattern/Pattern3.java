package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern3 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern3(n);
	}
	public static void Pattern3(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n*2;j++)
			{
				if(i==j || i==0)
					System.out.print("*");
				else if(i+j==(n*2)-1 && i<n-1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
