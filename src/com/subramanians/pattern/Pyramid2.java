package com.subramanians.pattern;
import java.util.Scanner;

public class Pyramid2 {
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		Pyramid2(n);
	}
	public static void Pyramid2(int n)
	{
        for (int i=n;i>0;i--)
        {
            for (int j=n-i;j>1;j--)
            {
                System.out.print(" ");
            }
            for (int j=1;j<=i;j++ )
            {
                System.out.print(i + " ");
            }
            System.out.println();
        }
	}
}
