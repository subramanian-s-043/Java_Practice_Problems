package com.subramanians.practice;

import java.util.Scanner;

class Node{
	int value;
	Node next;
	
	public Node()
	{
		
	}
	public Node(int value,Node next)
	{
		this.value=value;
		this.next=next;
	}
}

public class DeleteLastLinkedList {
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		Node first=null;
		Node next=null;
		while(true)
		{
			System.out.println("To End LinkedList give input as -1.Enter the Value: ");
			int temp=scanner.nextInt();
			if(temp!=-1)
			{
				if(first==null)
				{
					first=new Node(temp,null);
					next=first;
				}else {
					Node tempNode=new Node(temp,null);
					next.next=tempNode;
					next=tempNode;
				}	
			}else {
				break;
			}
		}
		System.out.println("Enter the K-th Last Element");
		int k=scanner.nextInt();
		Node firstPointer=first;
		for(int i=0;i<k;i++)
		{
			firstPointer=firstPointer.next;
		}
		Node secondPointer=first;
		while(firstPointer.next!=null)
		{
			if(firstPointer.next.next==null)
			{
				firstPointer.next=null;
				secondPointer=secondPointer.next;
				break;
			}else {
				secondPointer=secondPointer.next;	
			}
			firstPointer=firstPointer.next;
		}
		Node temp=secondPointer.next;
		secondPointer.next = secondPointer.next.next;
		temp.next=null;
		firstPointer.next=temp;
		Node traversal=first;
		while(traversal!=null)
		{
			System.out.println(traversal.value);
			traversal=traversal.next;
		}
	}
}
