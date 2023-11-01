package com.subramanians.arrays;
import java.util.Scanner;

public class Problem4 {
	static void printMatrix(int M[][],int rowSize,int colSize)
	{
		for(int i = 0;i<rowSize;i++) {
			for(int j=0;j<colSize;j++)
				System.out.print(M[i][j] + " ");
			System.out.println();
		}
	}

	static void matrixMultiply(int row1,int col1,int A[][],int row2,int col2,int B[][])
	{
		int i,j,k;
		if(row2!=col1)
		{
			System.out.println("Enter Valid Matrix for Multiplication");
			return;
		}
		int C[][]=new int[row1][col2];
		for(i=0;i<row1;i++){
			for(j=0;j<col2;j++){
				for(k=0;k<row2;k++){
					C[i][j]+=A[i][k]*B[k][j];
				}
			}
		}
		System.out.println("\nResultant Matrix:");
		printMatrix(C, row1, col2);
	}
	public void mainFunction() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the Row of Matrix A:");
		int rowA=scan.nextInt();
		System.out.println("Enter the Cloumn of Matrix A:");
		int colA=scan.nextInt();
		int A[][] =new int[rowA][colA];
		System.out.println("Enter the Row of Matrix B:");
		int rowB=scan.nextInt();
		System.out.println("Enter the Cloumn of Matrix B:");
		int colB=scan.nextInt();
		int B[][] =new int[rowB][colB];
		for(int i=0;i<rowA;i++)
		{
			for(int j=0;j<colA;j++)
			{
				System.out.println("Enter the "+ i + j +" Element:");
				A[i][j]=scan.nextInt();
			}
		}
		for(int i=0;i<rowB;i++)
		{
			for(int j=0;j<colB;j++)
			{
				System.out.println("Enter the "+ i + j +" Element:");
				B[i][j]=scan.nextInt();
			}
		}
		matrixMultiply(rowA,colA,A,rowB,colB,B);
	}
}