package com.subramanians.rajeesanproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {
	public static void main(String[] args) {
		PascalsTriangle app=new PascalsTriangle();
		app.start();
	}

	private void start() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number of Rows: ");
		int rows=scanner.nextInt();
		printOutput(generatePascals(rows));
	}

	private List<List<Integer>> generatePascals(int rows)
	{
		List<List<Integer>> pascals=new ArrayList<>();
		for(int i=0;i<rows;i++)
		{
			List<Integer> eachRow=new ArrayList<>();
			for(int j=0;j<=i;j++)
			{
				if(j==0 || i==j)
				{
					eachRow.add(1);
				}else {
					eachRow.add(pascals.get(i-1).get(j)+pascals.get(i-1).get(j-1));
				}
			}
			pascals.add(eachRow);
		}
		return pascals;
	}
	
	private void printOutput(List<List<Integer>> pascals) {
		System.out.print("[");
		for(List<Integer> row: pascals)
		{
			System.out.print(row.toString()+",");
		}
		System.out.print("]");
	}
}
