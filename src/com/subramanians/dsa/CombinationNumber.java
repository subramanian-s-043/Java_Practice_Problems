package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.List;

public class CombinationNumber {
	static List<List<Integer>> result=new ArrayList<>();
	static List<Integer> curr=new ArrayList<>();
	public static void main(String[] args) {
		int[] inputArray=new int[] {1,2,3,4};
		generateCombination(0,inputArray);
		for(List<Integer> r: result)
		{
			System.out.println(r.toString());
		}
	}
	private static void generateCombination(int i, int[] inputArray) {
		if(i==inputArray.length)
		{
			result.add(new ArrayList<Integer> (curr));
			return;
		}
		curr.add(inputArray[i]);
		generateCombination(i+1, inputArray);
		curr.remove(curr.size() - 1);
		generateCombination(i+1, inputArray);
	}
}
