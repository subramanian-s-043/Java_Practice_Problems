package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern2 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern2(n);
	}
	public static void Pattern2(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i+j<=n-1)
				{
					if(i==0 || j==0 || i+j==n-1)
						System.out.print("*");
					else
						System.out.print(" ");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
