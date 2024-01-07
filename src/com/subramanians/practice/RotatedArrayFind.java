package com.subramanians.practice;


public class RotatedArrayFind {
	public static void main(String[] args) {
		int[] inputArray=new int[] {15,16,19,20,25,1,3,4,5,7,10,14};
		int mid=(inputArray.length-1)/2;
		boolean isFound=true;
		int target=15;
		int inital=0;
		while(isFound)
		{
			if(inputArray[mid]==target)
			{
				isFound=false;
				break;
			}
			if(inputArray[inital]<inputArray[mid])
			{
				if(inputArray[mid]<target && inputArray[inputArray.length-1]>=target)
				{
					mid=0+mid/2;	
				}else {
					inital++;
				}
			}else
			{
				if(inputArray[mid]<target && inputArray[inputArray.length-1]>=target)
				{
					inital=mid+1;
					mid=(((inputArray.length-1) - mid)/2)+mid;	
				}else {
					mid--;
				}
			}
		}
		System.out.println(mid);
	}
}
