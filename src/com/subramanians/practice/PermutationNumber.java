package com.subramanians.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationNumber {
	static List<int[]> result=new ArrayList<>();
	public static void main(String[] args) {
		int[] inputArray=new int[] {1,2,3};
		generatePermutation(inputArray,0,inputArray.length);
			for(int[] b: result)
			{
				for(int a: b)
				{
					System.out.print(a+",");
				}
				System.out.println();
			}
		}

	private static void generatePermutation(int[] inputArray, int i, int j) {
		if(i>=j)
		{
			int tempArray[] = Arrays.copyOf(inputArray, j);
			result.add(tempArray);
		}
		for(int start=i;start<j;start++)
		{
			swap(inputArray,start,i);
			generatePermutation(inputArray, start+1, j);
			swap(inputArray,start,i);
		}
	}
	private static void swap(int[] inputArray, int i, int j) {
		int temp=inputArray[j];
		inputArray[j]=inputArray[i];
		inputArray[i]=temp;
	}
}
