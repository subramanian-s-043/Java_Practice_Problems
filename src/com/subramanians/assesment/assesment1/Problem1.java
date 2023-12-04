package com.subramanians.assesment.assesment1;
import java.util.Scanner;

public class Problem1 {
 public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[][] pattern= new int[n][n];
	int rows=n-1,initialRow=0,initialCol=0,lastCol=n-1,numb=1;
	while(initialRow<=rows || initialCol<=lastCol)
	{
		for(int i=initialCol;i<=rows;i++)
		{
			pattern[i][initialCol+i]=numb++;
			
		}
		lastCol--;
		for(int i=lastCol;i>=initialRow;i--)
		{
			pattern[rows][i]=numb++;
		}
		rows--;
		for(int i=rows;i>initialRow;i--)
		{
			pattern[i][initialRow]=numb++;
		}
		initialRow++;
		rows--;
		initialCol++;
	}
	for(int[] temp : pattern) 
	{
    	for(int i : temp)
    	{
    		if(i!=0)
    		{
    			if(i>=9) {
    				System.out.print(i+" ");
    			}else {
    			System.out.print(i+"  ");
    			}
    	} else{
    		System.out.print("   ");
    	}
    	}
    	System.out.println();
      }
}
}


/*
 * Logic
 * while(initialRow<=rows || initialCol<=lastCol)
{
	for(int i=initialRow;i<=rows;i++)
	{
		pattern[i][initialRow+i]=numb++;
		
	}
	rows--;
	for(int i=rows;i>=initialRow;i--)
	{
		pattern[i][lastCol]=numb++;
	}
	lastCol--;
	initialCol++;
	for(int i=lastCol;i>=initialCol;i--)
	{
		pattern[initialRow][i]=numb++;
	}
	initialCol++;
	rows--;
	initialRow++;
}*/


































//Rough Implementation
//while(initial<=row || initialCol<lastCol)
//{
//	for(int i=initial;i<=row;i++)
//	{
//		if(start<=(((n*n)+n)/2))
//		{
//			pattern[i][initialCol+i]=start++;
//		}
//	}
////	initialCol++;
//	if(initial==0)
//	{
//		initialCol++;
//	}else {
//		initialCol+=initialCol;
//	}	
//	row--;
//	for(int i=row;i>=initial;i--)
//	{
//		if(start<=(((n*n)+n)/2))
//		{
//			pattern[i][lastCol]=start++;
//		}
//	}
////	if(initial==0)
////	{
////		lastCol--;
////	}else {
////		lastCol-=2;
////	}
//	lastCol--;
//	for(int i=lastCol;i>=initialCol;i--)
//	{
//		if(start<=(((n*n)+n)/2))
//		{
//			pattern[initial][i]=start++;
//		}
//	}
////	initial++;
//	if(initial==0)
//	{
//		initial++;
//	}else {
//		initial+=initial;
//	}
//	row--;
//}
//
//while(initial<=row || initialCol<=lastCol)
//{
//	for(int i=initial;i<=row;i++)
//	{
//		if(start<=(((n*n)+n)/2))
//		{
//				pattern[i][initialCol+i]=start++;
//		}
//	}
//	initialCol++;
//	row--;
//	for(int i=row;i>=initial;i--)
//	{
//		if(start<=(((n*n)+n)/2))
//		{
//			pattern[i][lastCol]=start++;
//		}
//	}
//	if(initial!=0)
//	{
//		initialCol++;
//	}
//	lastCol--;
//	for(int i=lastCol;i>=initialCol;i--)
//	{
//		if(start<=(((n*n)+n)/2))
//		{
//			pattern[initial][i]=start++;
//		}
//	}
//	if(initial!=0)
//	{
//		initialCol++;
//	}
//	initial++;
////	initialCol++;
//	row--;
//} 