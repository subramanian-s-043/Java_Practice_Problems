package com.subramanians.pattern;
import java.util.Scanner;

public class Pyramid3 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pyramid3(n);
	}
	public static void Pyramid3(int n)
	{
        for (int i=n;i>0;i--)
        {
            for (int j=n-i;j>1;j--)
            {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++ )
            {
                System.out.print(" *");
            }
            System.out.println();
        }
	}
}
