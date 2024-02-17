package com.subramanians;

public class ChochlatePaper {
	public int chocolates(int n)
	{
		int total=0;
		if(n==1)
			return 2;
		else
			total=n+chocolates(n/2);
		return total;
	}
	public static void main(String[] args) {
		int n=10;
		int rem=0;
		int total=0;
		while(n>=2)
		{
			total+=n;
			if(n%2!=0)
				rem+=n%2;
			n/=2;
			if(rem!=0)
			{
				n+=rem;
				rem=0;
			}
		}
		System.out.println(total);
	}
}
/*
 * 10 -> 5 -> 2 -> 1 -> 1 *
 * 7 -> 3 -> 2 -> 1 /
 */