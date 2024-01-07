package com.subramanians.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixSorting {
	public static void main(String[] args) {
		MatrixSorting app=new MatrixSorting();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Size: ");
		int size=scanner.nextInt();
		int[][] inputArray=new int[size][size];
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.println("Enter "+(i+1) +","+(j+1)+": ");
				inputArray[i][j]=scanner.nextInt();
			}
		}
		System.out.println("Choose the type of sorting: ");
		System.out.println(" 1.Vertical \n 2.Horizontal \n 3.Diagnoal");
		int choice=scanner.nextInt();
		switch(choice)
		{
		case 1:
			inputArray=app.verticalSorting(inputArray);
			break;
		case 2:
			inputArray=app.horizontalSorting(inputArray);
			break;
		case 3:
			inputArray=app.diagonalSort(inputArray);
			break;
		}
		for(int[] a:inputArray)
		{
			for(int b:a)
			{
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}
	private int[][] horizontalSorting(int[][] inputArray) {
		int i=0,size=inputArray.length;
		while(i!=size)
		{
			int[] temp=new int[size];
			for(int j=0;j<size;j++)
			{
				temp[j]=inputArray[i][j];
			}
			Arrays.sort(temp);
			for(int j=0;j<size;j++)
			{
				inputArray[i][j]=temp[j];
			}
			i++;
		}
		return inputArray;
	}
	private int[][] verticalSorting(int[][] inputArray) {
		int j=0,size=inputArray.length;
		while(j!=size)
		{
			int[] temp=new int[size];
			for(int i=0;i<size;i++)
			{
				temp[i]=inputArray[i][j];
			}
			Arrays.sort(temp);
			for(int i=0;i<size;i++)
			{
				inputArray[i][j]=temp[i];
			}
			j++;
		}
		return inputArray;
	}
	private int[][] diagonalSort(int[][] inputArray)
	{
		int size=inputArray.length;
		int i=0;
		int j=size-1;
		while(j!=0)
		{
			if(j==size-1)
			{
				j--;
				continue;
			}else {
				int[] temp=new int[((size)-j)];
				int tempX=i;
				int tempY=j;
				for(int k=0;k<(size-j);k++)
				{
					temp[k]=inputArray[tempX++][tempY++];
				}
				if(temp.length > 1)
				{
					Arrays.sort(temp);
					tempX=i;
					tempY=j;
					for(int k=0;k<(size)-j;k++)
					{
						inputArray[tempX++][tempY++]=temp[k];
					}
				}else {
					inputArray[i][j]=temp[0];
				}
			}
			j--;
		}
		
		while(i!=size-1)
		{
			if(i==size-1)
			{
				break;
			}else {
				int[] temp=new int[((size)-i)];
				int tempX=i;
				int tempY=j;
				for(int k=0;k<(size)-i;k++)
				{
					temp[k]=inputArray[tempX++][tempY++];
				}
				if(temp.length > 1)
				{
					Arrays.sort(temp);
					tempX=i;
					tempY=j;
					for(int k=0;k<(size)-i;k++)
					{
						inputArray[tempX++][tempY++]=temp[k];
					}
				}else {
					inputArray[i][j]=temp[0];
				}
			}
			i++;
		}
		return inputArray;
	}
}
