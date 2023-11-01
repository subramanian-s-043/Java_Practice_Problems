package com.subramanians.pattern;
import java.util.Scanner;

public class Pyramid4 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pyramid4(n);
	}
	public static void Pyramid4(int n)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0;j<n-1;j++)
				if(i+j>=n-1)
					System.out.print(j+1);
				else
					System.out.print(" ");
			for(int j=0;j<=i;j++)
			{
				if(j<=n)
					System.out.print(n-j);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
