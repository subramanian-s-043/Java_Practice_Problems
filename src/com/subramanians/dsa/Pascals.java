package com.subramanians.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pascals {
	public static void main(String[] args) {
		Pascals start=new Pascals();
		start.generate();
	}
    public void generate() {
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("Enter number of Rows for triangle: ");
    	int numRows=scanner.nextInt();
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++)
        {
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0 || j==i)
                {
                    row.add(1);
                }else
                {
                    row.add(ans.get(i-1).get(j)+ans.get(i-1).get(j-1));
                }
            }
            ans.add(row);
        }
        for(List<Integer> list: ans)
        {
        	for(Integer innerList: list)
        	{
        		System.out.print(innerList+" ");
        	}
        	System.out.println();
        }
    }
}
