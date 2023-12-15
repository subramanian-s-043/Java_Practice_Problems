package com.subramanians.dsa;

import java.util.Scanner;

public class MergeSort {
	public static void main(String[] args) {
		MergeSort start=new MergeSort();
		start.getInput();
	}
	private void getInput() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the size of Array: ");
		int n=scanner.nextInt();
		int[] arr=new int[n];
		System.out.println("Enter the array as space-separated: ");
		for(int i=0;i<n;i++)
		{
			arr[i]=scanner.nextInt();
		}
		scanner.close();
		divide(arr);
		print(arr);
	}
	private void print(int[] arr)
	{
		for(int ele:arr)
		{
			System.out.print(ele+" ");
		}
	}
	private void divide(int[] arr) {
		int n=arr.length;
		if(n<2)
			return;
		else {
			int mid=n/2;
			int[] left=new int[mid];
			int[] right=new int[n-mid];
			for(int i=0;i<mid;i++) {
				left[i]=arr[i];
			}
			for(int i=mid;i<n;i++) {
				right[i-mid]=arr[i];
			}
			divide(left);
			divide(right);
			merge(left,right,arr);
		}
		
	}
	private void merge(int[] left,int[] right,int[] arr) {
		int i=0,j=0,k=0;
		int leftLength=left.length;
		int rLength=right.length;
		while(i<leftLength && j<rLength) {
			if(left[i]<=right[j])
			{
				arr[k]=left[i];
				i++;
			}else {
				arr[k]=right[j];
				j++;
			}
			k++;
		}
		while(i<leftLength) {
			arr[k]=left[i];
			k++;
			i++;
		}
		while(j<rLength) {
			arr[k]=right[j];
			k++;
			j++;
		}
	}
}
