package com.subramanians.dsa;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression {
	public static void main(String[] args) {
		PostfixExpression start =new PostfixExpression();
		start.getInput();
	}
	private void getInput()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Postfix Expression: ");
		String expression=scanner.nextLine();
		evaluate(expression);
		scanner.close();
	}
	private void evaluate(String expression)
	{
		Stack<Integer> numbers=new Stack<>();
		for(int i=0;i<expression.length();i++)
		{
			char ch=expression.charAt(i);
			if(ch==' ')
				continue;
			else if(Character.isDigit(ch))
			{
				int n=0;
				while(Character.isDigit(ch))
				{
					n=n*10+(int)(ch-'0');
					i++;
					ch=expression.charAt(i);
				}
				i--;
				numbers.push(n);
			}else
			{
				int operand1=numbers.pop();
				int operand2=numbers.pop();
				switch(ch)
				{
				case '+':
					numbers.push(operand2+operand1);
					break;
				case '-':
					numbers.push(operand2-operand1);
					break;
				case '*':
					numbers.push(operand1*operand2);
					break;
				case '/':
					numbers.push(operand2/operand1);
					break;
				}
			}
		}
		System.out.println(numbers.pop());
	}
}
