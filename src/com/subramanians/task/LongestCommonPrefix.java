package com.subramanians.task;


public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] input = new String[]{"flower","flow","flight"};
		String prev=input[0];
		StringBuilder out = new StringBuilder();
		for(int i=1;i<input.length;i++)
		{
			String curr=input[i];
			StringBuilder temp = new StringBuilder();
			for(int j=0;j<curr.length();j++)
			{
				if(j >= prev.length() || j==curr.length()-1)
				{
					if(out.length()!=0)
					{
						StringBuilder t = new StringBuilder();
						for(int k=0;k<temp.length();k++)
						{
							if(out.charAt(k)==temp.charAt(k))
							{
								t.append(out.charAt(k));
							}
						}
						out = t;
					}else {
						out=temp;
					}
					prev=curr;
					break;
				}
				if(curr.charAt(j)==prev.charAt(j))
				{
					temp.append(curr.charAt(j));
				}
			}
		}
		System.out.println("Longest Common Prefix: "+out.toString());
	}
}
