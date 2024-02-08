package com.subramanians.task;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Start Date(YYY-MM-DD): ");
		String start = scanner.nextLine();
		LocalDate startDate = LocalDate.parse(start);
		System.out.println("Enter the End Date(YYY-MM-DD): ");
		String end = scanner.nextLine();
		LocalDate endDate = LocalDate.parse(end);
		
		long days = ChronoUnit.DAYS.between(startDate, endDate);
		System.out.println(days);
		
	}
}
