package com.subramanians;

public class Check {
	static void add()
	{
		System.out.println("Static Executed");
	}
	static {
		add();
	}
	public static void main(String[] args) {
		System.out.println("Main Executed");
	}
}
