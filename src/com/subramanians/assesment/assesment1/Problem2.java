package com.subramanians.assesment.assesment1;
import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number:");
		int n=sc.nextInt();
		boolean ans=false;
		String str=String.valueOf(n);
		for(int i=0;i<str.length()-1;i++)
		{
			char t=str.charAt(i);
			char t1=str.charAt(i+1);
				if(Math.abs((t-'0')-(t1-'0'))==1)
				{
					ans=true;
				}else {
					ans=false;
					break;
				}
		}
		if(ans)
		{
			System.out.println(n+" is a jumbled number");
		}else {
			System.out.println(n+" is not a jumbled number");
		}
	}
}
