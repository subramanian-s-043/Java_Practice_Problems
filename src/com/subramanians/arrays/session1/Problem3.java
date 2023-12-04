package com.subramanians.arrays.session1;
import java.util.Scanner;

public class Problem3 {
	public static void printPattern(String str)
	{
		int len=str.length();
	    for (int i=0;i<len;i++) { 
	        int j=len-1- i; 
	        for (int k=0;k<len;k++) { 
	            if (k==i||k==j)
	            {
	                System.out.print(str.charAt(k)); 
	            }else {
	                System.out.print(" "); 
	            }
	        } 
	        System.out.println(""); 
	    }
	}
	 public void mainFunction() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the String:");
		String input=scan.nextLine();
		printPattern(input);
	}
}
