package com.subramanians.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchDictonary {
	public static void main(String[] args) {
		char[][] wordMatrix=new char[][] {{'a','z','o','l'},
										  {'n','x','h','o'},
										  {'v','y','i','v'},
										  {'o','r','s','e'}};
		List<String> dictionary=new ArrayList<>();
		dictionary.add("van");
		dictionary.add("zoho");
		dictionary.add("love");
		dictionary.add("is");
		dictionary.add("are");
		List<String> output=new ArrayList<>();
		Queue<String[]> possibilites=new LinkedList<>();
		for(int i=0;i<wordMatrix.length;i++)
		{
			for(int j=0;j<wordMatrix[0].length;j++)
			{
				possibilites.add(new String[] {String.valueOf(i),String.valueOf(j),String.valueOf(wordMatrix[i][j])});
				while(!possibilites.isEmpty())
				{
					String[] temp=possibilites.poll();
					if(dictionary.contains(temp[2]) )
					{
						output.add(temp[2]);
					}
					if(Integer.valueOf(temp[0])+1<wordMatrix.length)
					{
						possibilites.add(new String[] {String.valueOf(Integer.valueOf(temp[0])+1),String.valueOf(Integer.valueOf(temp[1])),temp[2]+String.valueOf(wordMatrix[Integer.valueOf(temp[0])+1][Integer.valueOf(temp[1])])});
					}
					if(Integer.valueOf(temp[1])+1<wordMatrix[0].length)
					{
						possibilites.add(new String[] {String.valueOf(Integer.valueOf(temp[0])),String.valueOf(Integer.valueOf(temp[1])+1),temp[2]+String.valueOf(wordMatrix[Integer.valueOf(temp[0])][Integer.valueOf(temp[1])+1])});
					}
				}
			}
		}
		for(String a:output)
		{
			System.out.println(a);
		}
	}
}
