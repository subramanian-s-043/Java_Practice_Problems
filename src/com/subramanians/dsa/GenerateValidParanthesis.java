package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class GenerateValidParanthesis {
	public static void main(String[] args) {
		GenerateValidParanthesis start = new GenerateValidParanthesis();
		start.getInput();
	}
	char[] arr;
	List<String> result=new ArrayList<>();
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of paranthesis: ");
		int n=scanner.nextInt();
		arr=new char[2*n];
		for(int i=0;i<n;i++)
		{
			arr[i]='(';
		}
		for(int i=n;i<2*n;i++)
		{
			arr[i]=')';
		}
		generate(0,arr.length,result);
		System.out.println(result.toString());
		scanner.close();
	}
	private void generate(int start,int end,List<String> result)
	{
		if (start >= end) {
			char tempArray[] = Arrays.copyOf(arr, end);
			if(isValid(new String(tempArray)))
			{
				if(!result.contains(new String(tempArray)))
				{
					result.add(new String(tempArray));
				}
			}
			return;
		}
		for (int i = start; i < end; i++) {
			swap(i, start, arr);
			generate(start + 1, end, result);
			swap(i, start, arr);
		}
	}
	private void swap(int i,int j,char[] arr)
	{
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	private boolean isValid(String input)
	{
		Stack<Character> open=new Stack<>();
		for(int i=0;i<input.length();i++)
		{
			if(input.charAt(i)=='(')
			{
				open.add(input.charAt(i));
			}
			if(input.charAt(i)==')')
			{
				if(open.isEmpty())
				{
					return false;
				}else
				{
					open.pop();
				}
			}
		}
		return open.isEmpty();
	}
	
	
}
