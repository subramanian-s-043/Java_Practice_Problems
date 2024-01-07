package com.subramanians.practice;

import java.util.Scanner;

public class Permutation {
	public static void main(String[] args) {
		Permutation app=new Permutation();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string: ");
		String input=scanner.nextLine();
		char[] charArray=input.toCharArray();
		app.generatePermutations(charArray,0,input.length()-1);
	}

	private void generatePermutations(char[] charArray,int left,int right) {
		if(left==right)
		{
			System.out.println(charArray);
		}else {
			for(int i=left;i<=right;i++)
			{
				swap(charArray,left,i);
				generatePermutations(charArray, left+1, right);
				swap(charArray,left,i);
			}
		}
	}

	private void swap(char[] charArray, int left, int i) {
		char temp=charArray[left];
		charArray[left]=charArray[i];
		charArray[i]=temp;
		
	}
	
}
