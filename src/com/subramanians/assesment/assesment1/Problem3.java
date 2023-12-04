package com.subramanians.assesment.assesment1;
import java.util.Scanner;
import java.util.Stack;

public class Problem3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Input:");
		String exp=sc.nextLine();
		String paran="";
		boolean ans=false;
		for(int i=0;i<exp.length();i++)
		{
			if(exp.charAt(i)=='('||exp.charAt(i)==')'||
					exp.charAt(i)=='['||exp.charAt(i)==']'||
					exp.charAt(i)=='{'||exp.charAt(i)=='}')
			{
				paran+=exp.charAt(i);
			}
		}
		if(isValidParanthesis(paran))
		{
			for(int i=0;i<exp.length();i++)
			{
				if(exp.charAt(i)=='+' || exp.charAt(i)=='-'||
						exp.charAt(i)=='*' || exp.charAt(i)=='/')
				{
					if(i+1<exp.length() && i!=0)
					{
						if(Character.isLetter(exp.charAt(i+1))&&Character.isLetter(exp.charAt(i-1))||
								(exp.charAt(i+1)=='('&&exp.charAt(i-1)==')'))
						{
							ans=true;
						}else {
							ans=false;
						}
					}
				}
			}
		}else {
			ans=false;
		}
		if(ans)
		{
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}

	private static boolean isValidParanthesis(String paranthesis) {
		Stack<Character> openParanthesis=new Stack<Character>();
		for(int i=0;i<paranthesis.length();i++)
		{
			if(paranthesis.charAt(i)=='('||paranthesis.charAt(i)=='{'||
					paranthesis.charAt(i)=='[')
			{
				openParanthesis.push(paranthesis.charAt(i));
			}
			else 
			{
			char last=openParanthesis.pop();
			switch(last)
			{
				case '(':
					if(last=='['||last=='{')
						return false;
						break;
				case '[':
					if(last=='('||last=='{')
						return false;
						break;
				case '{':
					if(last=='('||last=='[')
						return false;
						break;
			}
			}
		}
			
		return openParanthesis.isEmpty();
	}
}
