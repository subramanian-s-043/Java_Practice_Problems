package com.subramanians.assesment.assesment1;
import java.util.*;

public class Problem5 {
 public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of Strings to be Entered:");
	int n=sc.nextInt();
	sc.nextLine();
	String[] inp=new String[n];
	for(int i=0;i<n;i++)
	{
		System.out.println("Enter the String"+(i+1));
		inp[i]=sc.nextLine();
	}
	for(int i=0;i<n;i++)
	{
		char[] str=inp[i].toCharArray();
		Arrays.sort(str);
		String temp="";
		for(int j=str.length - 1;j>=0;j--)
		{
			temp+=str[j];
			
		}
		System.out.println("String"+(i+1)+":" + temp);
	}
}
}
