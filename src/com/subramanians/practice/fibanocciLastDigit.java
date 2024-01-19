package com.subramanians.practice;

import java.util.Scanner;

public class fibanocciLastDigit {
	public static void main(String[] args) {
		fibanocciLastDigit app=new fibanocciLastDigit();
		app.start();
	}

	private void start() {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the Number: ");
		int n=scanner.nextInt();
		int fibanocci=findfibanocci(n);
		System.out.println(fibanocci%10);
	}

	private int findfibanocci(int n) {
		int first=0;
		int second=1;
		for(int i=1;i<n;i++)
		{
			int curr=first+second;
			first=second;
			second=curr;
		}
		return  n>1 ? second : first;
	}
}
