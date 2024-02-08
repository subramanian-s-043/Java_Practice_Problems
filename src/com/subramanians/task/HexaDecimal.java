package com.subramanians.task;

import java.math.BigInteger;
import java.util.Scanner;

public class HexaDecimal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String input = scanner.nextLine();
		BigInteger change = new BigInteger(input.getBytes());
		String hexDec = change.toString(16);
		System.out.println("Hexa-Decimal Representation: "+hexDec);
	}
}
