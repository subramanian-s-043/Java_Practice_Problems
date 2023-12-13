package com.subramanians.dsa;

import java.util.Scanner;

public class MatrixRotation {
	public static void main(String[] args) {
		MatrixRotation start=new MatrixRotation();
		start.Rotation();
	}
	private void Rotation()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Size of Square Matrix");
		int row=scanner.nextInt();
		int[][] matrix=new int[row][row];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{
				System.out.println("Enter the value ("+(i+1)+","+(j+1)+"): ");
				matrix[i][j]=scanner.nextInt();
			}
		}
		scanner.close();
		rotate(matrix);
	}
	private void rotate(int[][] matrix)
	{
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=i+1;j<matrix.length;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		for(int i=0;i<matrix.length;i++)
		{
			int start=0;
			for(int j=matrix.length-1;j>=start;j--)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][start];
				matrix[i][start]=temp;
				start++;
			}
		}
		for(int[] col: matrix)
		{
			for(int ele: col)
			{
				System.out.print(ele+" ");
			}
			System.out.println();
		}
	}
}
