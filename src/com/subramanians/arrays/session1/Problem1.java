package com.subramanians.arrays.session1;
import java.util.Scanner;

/*
 * In this approach, I handled the corner case , that if a child name is in previous generation for example
 * <”luke”, “shaw”>
 * <”wayne”, “rooney”>
 * <”rooney”, “ronaldo”>
 * <”shaw”, “rooney”>
 * let say wan to search for ronaldo,
 * ronaldo has child rooney
 * rooney has child shaw & wayne -> Grnad Children
 * shaw has child luke -> Great-grandchildren
 * 
 * So output will be 3.
 * 
 * */

public class Problem1 {
	public static int numberOfGrandchildren(String[][] members,String find) {
		int count=0;
		String child="";
		for(int i=0;i<members.length;i++)
		{
			if(members[i][1].equals(find) && child.equals(""))
			{
				child=members[i][0];
				i=0;
			}else if(members[i][1].equals(child)){
				count++;
			}
		}
		return count;
	}
	/*	code for corner-case to find great-grand children
	 * int count=0;
		for(int i=0;i<members.length;i++)
		{
			if(members[i][1].equals(find))
			{
				numberOfGrandchildren(members, members[i][0]);
			}else {
				count++;
			}
		}
		return count;*/
	public void mainFunction() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number Of Generations:");
		int generations = scan.nextInt();
		String[][] members = new String[generations][2];
		String find;
		for(int i=0;i<generations;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(j==0) 
				{
					System.out.println("Enter the "+ (i+1) +" generation Child Name:");
					members[i][j]=scan.next();
				}else 
				{
					System.out.println("Enter the "+ (i+1) +" generation Father Name:");
					members[i][j]=scan.next();
				}
			}
		}
		System.out.println("Enter the Name to find:");
		find=scan.next();
		scan.close();
		System.out.println(numberOfGrandchildren(members,find));
	}
}
