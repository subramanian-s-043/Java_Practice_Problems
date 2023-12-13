package com.subramanians.dsa;

import java.util.Scanner;

public class PrimeNumberGenerator {
	public static void main(String[] args) {
		PrimeNumberGenerator start=new PrimeNumberGenerator();
		start.prime();
	}
	private void prime()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the start range of Prime: ");
		int start=scanner.nextInt();
		System.out.println("Enter the End range of Prime: ");
		int end=scanner.nextInt();
		for(int i=start;i<=end;i++)
		{
			if(isPrime(i))
			{
				System.out.println(i);
			}
		}
	}
	private boolean isPrime(int n)
	{
	     int count = 0;
	     if (n < 2)
	       return false;
	     for (int i = 2; i < n; i++)
	    {
	    	 if (n % i == 0)
	    		 return false;
	     }
	     return true;
	}
}
