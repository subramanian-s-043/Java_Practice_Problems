package com.subramanians.pattern;
import java.util.Scanner;

public class Pyramid5 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pyramid5(n);
	}
	public static void Pyramid5(int n)
	{
		System.out.print(" ");
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n-i; j++)
				System.out.print(" ");
		for(int j=1,k=2*i-1; j<=2*i-1; j++,k--)
		{
			if(j <= k)
				System.out.print(j);
			else
				System.out.print(k);
		}
		System.out.println();
		System.out.print(" ");
		}
	}
}
