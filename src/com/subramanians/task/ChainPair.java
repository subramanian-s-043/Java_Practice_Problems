package com.subramanians.task;

public class ChainPair {
	public static void main(String[] args) {
		int[][] input=new int[][]{{1,2},{2,3},{3,4}};
		int count=0;
		for(int i=0;i<input.length;i++)
		{
			for(int j=i+1;j<input.length;j++)
			{
				if(input[j][0] < input[i][0])
				{
					int[] temp = input[i];
					input[i] = input[j];
					input[j] =temp;
				}
			}
		}
		int[] curr=input[0];
		count++;
		for(int i=1;i<input.length;i++)
		{
			if(input[i][0] > curr[1])
			{
				curr = input[i];
				count++;
			}
		}
		System.out.println(count);
	}
}
