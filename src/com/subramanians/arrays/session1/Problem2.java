package com.subramanians.arrays.session1;
import java.util.Scanner;

public class Problem2 {
    static boolean isPerfectSquare(int x)
    {
        if (x >= 0) {
            int sqr = (int)Math.sqrt(x);
            return ((sqr*sqr)==x);
        }
        return false;
    }
      public static int[][] sortByweight(int arr[][]) {
    	  int n = arr.length;
    	  for (int i = 0; i < n; i++) 
    	  {
    		  for (int j = 0; j < n; j++)
    		  {
    			  for (int k = 0; k < 2; k++)
    			  {
    				  for (int l = 0; l < 2; l++)
    				  {
    					  if (arr[i][k] < arr[i][k + 1]) {
    						   int temp = arr[i][k];
    						   arr[i][k] = arr[i][k + 1];
    						   arr[i][k + 1] = temp;
    						}
             }
          }
       }
    }
    	  return arr;
 }
	public static int[][] sortNumberWeights(int[] arr) {
		int[][] out=new int[arr.length][2];
		for(int i=0;i<arr.length;i++)
		{
			int weight=0;
			if(isPerfectSquare(arr[i]))
			{
				weight+=5;
			}
			if(arr[i]%4==0 && arr[i]%6==0)
			{
				weight+=4;
			}
			if(arr[i]%2==0)
			{
				weight+=3;
			}
			out[i][0]=arr[i];
			out[i][1]=weight;
		}
		out = sortByweight(out);
		return out;
	}
 public void mainFunction() {
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the number of numbers:");
	int size=scan.nextInt();
	int[] numberSet=new int[size];
	for(int i=0;i<size;i++)
	{
		System.out.println("Enter the "+(i+1)+" number");
		numberSet[i]=scan.nextInt();
	}
	scan.close();
	int[][] output=sortNumberWeights(numberSet);
	for(int i=0;i<size;i++)
	{
		System.out.println(output[i][0]+" "+output[i][1]);
	}
}
}