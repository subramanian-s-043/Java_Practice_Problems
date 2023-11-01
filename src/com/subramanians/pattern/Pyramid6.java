package com.subramanians.pattern;
import java.util.Scanner;

public class Pyramid6 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pyramid6(n);
	}
	public static void Pyramid6(int n)
	{
        for(int i=0; i<n; i++)
        {
            for(int j=n-i; j>1; j--)
            {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++ )
            {
                System.out.print("* ");
            }
            System.out.println();
        }
	}
}
