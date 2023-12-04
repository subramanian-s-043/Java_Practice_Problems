package com.subramanians.arrays.session1;
import java.util.*;

public class Problem5 {
	 static void rearrange(int arr[],int n)
	    {
	        int evenPos=n/2;
	        int oddPos=n-evenPos;
	        int[] tempArr = new int [n];
	        for(int i=0;i<n;i++)
	            tempArr[i] = arr[i];
	        Arrays.sort(tempArr);
	        int j=oddPos-1;
	        for(int i=0;i<n;i+=2){
	            arr[i]=tempArr[j];
	            j--;
	        }
	        j=oddPos;
	        for(int i=1;i<n;i+= 2) {
	            arr[i]=tempArr[j];
	            j++;
	        }
	        printArray(arr,n);
	    }
	    static void printArray(int arr[],int size)
	    {
	        for (int i=0;i<size;i++)
	            System.out.print(arr[i] + " ");
	        System.out.println();
	    }
	public void mainFunction() {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of Elements");
		int len=scan.nextInt();
		int[] input=new int[len];
		for(int i=0;i<len;i++)
		{
			System.out.println("Enter the "+ i +" Element");
			input[i]=scan.nextInt();
		}
		rearrange(input,len);
	}
}
