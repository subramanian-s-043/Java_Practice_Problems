package com.subramanians.pattern;
import java.util.Scanner;

public class Pattern7 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pattern7(n);
	}
	public static void Pattern7(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i>=j && i+j<=n)
					if((i==j&& n/2!=i) || i+j==n-1 || j==0)
						System.out.print("*");
					else
						System.out.print(" ");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
}
