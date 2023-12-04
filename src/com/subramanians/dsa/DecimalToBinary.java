package com.subramanians.dsa;
import java.util.Scanner;

public class DecimalToBinary {
	static String decimalToBinary(int n) 
    {
        String tempbin="";
        String binary="";
        int temp=n;
        while (temp > 0) {
        	int val=temp%2;
            temp = temp/2;
            tempbin+= Integer.toString(val);
        } 
        for(int i=tempbin.length()-1;i>=0;i--)
        {
        	binary+=tempbin.charAt(i);
        }
        return binary; 
    } 
	public static void mainFunction(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Decimal Number:");
		int input=sc.nextInt();
		System.out.println(decimalToBinary(input));
	}
}
