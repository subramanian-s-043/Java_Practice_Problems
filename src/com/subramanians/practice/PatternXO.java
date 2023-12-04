package com.subramanians.practice;

import java.util.Arrays;
import java.util.Scanner;

public class PatternXO {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		char[][] ans=new char[a][a];
		for (char[] row: ans)
		    Arrays.fill(row, ' ');
		char print='X';
		int startRow=0,startCol=0,endCol=a-1,endRow=a-1;
		 while(startRow<=a/2)
	        {
	            for(int j=startCol;j<=endCol;j++)
	            {
	                ans[startRow][j]=print;
	            }
	            startRow++;
	            for(int j=startRow;j<=endRow;j++)
	            {
	                ans[j][endCol]=print;
	            }
	            endCol--;
	            startRow--;
	            for(int j=endCol;j>=startRow;j--)
	            {
	                ans[endRow][j]=print;
	            }
	            endRow--;
	            startRow++;
	            for(int j=endRow;j>=startRow;j--)
	            {
	                ans[j][startCol]=print;
	            }
	            startCol++;
	            if(print=='X')
	            {
	            	print='0';
	            }else {
	            	print='X';
	            }
	        }
		for(char[] in:ans)
		{
			for(char n: in)
			{
				System.out.print(n);
			}
			System.out.println();
		}
	}
}
