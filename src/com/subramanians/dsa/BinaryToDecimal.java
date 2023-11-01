package com.subramanians.dsa;
import java.util.Scanner;

public class BinaryToDecimal {
	static int binaryToDecimal(int n) 
    {
        int decimal=0;  
        int base=1; 
        int temp=n; 
        while(temp > 0) { 
            int last_digit = temp%10; 
            temp = temp/10; 
            decimal+= last_digit*base; 
            base = base*2; 
        } 
        return decimal; 
    } 
	public void mainFunction() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Binary Number:");
		int input=sc.nextInt();
		System.out.println(binaryToDecimal(input));
	}
}
