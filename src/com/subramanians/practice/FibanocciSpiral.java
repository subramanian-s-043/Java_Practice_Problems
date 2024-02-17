package com.subramanians.practice;

import java.util.Scanner;

public class FibanocciSpiral {
	public static void main(String[] args) {
		FibanocciSpiral app = new FibanocciSpiral();
		app.start();
	}
	public void start()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the m: ");
		int m=scanner.nextInt();
		System.out.println("Enter the n: ");
		int n=scanner.nextInt();
		int[][] out=new int[m][n];
		out[0][1]=1;
		int curr =1;
		int prev=0;
		int startRow=0,endRow=m-1,startCol=0,endCol=n-1;
		for(int i=startRow;i<=endRow;i++)
		{
			for(int j=startCol;j<=endCol;j++)
			{
				if(j==0) j+=2;
				out[i][j]=(prev+curr);
				prev=curr;
				curr=out[i][j];
			}
			for(int k=startRow+1;k<=endRow;k++)
			{
				out[k][endCol]=(prev+curr);
				prev=curr;
				curr=out[k][endCol];
			}
			endCol--;
			for(int l=endCol;l>=startCol;l--)
			{
				if(out[endRow][l]!=0)
					break;
				out[endRow][l]=(prev+curr);
				prev=curr;
				curr=out[endRow][l];
			}
			endRow--;
			for(int h=endRow;h>startRow;h--)
			{
				out[h][startCol]=(prev+curr);
				prev=curr;
				curr=out[h][startCol];
			}
			startCol++;
			startRow++;
		}
		for(int[] ele:out)
		{
			for(int val : ele)
			{
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
	}
}
