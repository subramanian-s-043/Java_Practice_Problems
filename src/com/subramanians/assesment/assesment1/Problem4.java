package com.subramanians.assesment.assesment1;
import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Input:");
		String input=sc.next();
		sc.nextLine();
		System.out.println("Number of rows:");
		int rowLength=sc.nextInt();
		char[][] pattern=new char[rowLength][input.length()];
		for (char[] row: pattern)
		    Arrays.fill(row, ' ');
		fillPattern(pattern,input,rowLength);
		for(int i=0;i<rowLength;i++)
		{
			for(int j=0;j<input.length();j++)
			{
					System.out.print(pattern[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	private static void fillPattern(char[][] pattern, String inputString, int numRows) {
	    int diffCount=0;
	    int stringIndex=0;
	    for (int col=0;col<inputString.length();col++)
	    {
	        for (int row=0;row<numRows;row++)
	        {
	            if (col==0||col%(numRows - 1)==0)
	            {
	                pattern[row][col]=inputString.charAt(stringIndex);
	                stringIndex++;
	                if (stringIndex>=inputString.length())
	                {
	                    return;
	                }
	                diffCount = 0;
	            } else {
	                if ((numRows - 1) - diffCount == row) {
	                    pattern[row][col]=inputString.charAt(stringIndex);
	                    stringIndex++;
	                    if (stringIndex>=inputString.length()) {
	                        return;
	                    }
	                }
	            }
	        }
	        diffCount++;
	    }
	}

}

//for(int i=0;i<input.length();i++) 
//{
//	for(int j=0;j<rowLength;j++)
//	{
//		if(i==0 || i%(rowLength-1)==0)
//		{
//			pattern[j][i]=input.charAt(k);
//			k++;
//			if(k>=input.length())
//			{
//				break;
//			}
//			sub=0;
//		}else
//		{
//			if((rowLength)-sub-1==j) {
//				pattern[j][i]=input.charAt(k);
//				k++;
//				if(k>=input.length()) 
//				{
//					break;
//				}
//			}
//		}
//	}
//	sub++;
//}
