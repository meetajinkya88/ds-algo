package practice.imp;

import java.util.Scanner;

import practice.LinkedList;
import practice.ListNode;

/**
 * 
 * @author ajinkyab
 * 
 */
/*
 * 
 * Given a Linked List of length n and block length k rotate in circular manner towards right/left each block by a number d. If d is positive rotate towards right else rotate towards left.

Examples:

Input : 1->2->3->4->5->6->7->8->9->NULL, 
        k = 3 
        d = 1
Output : 3->1->2->6->4->5->9->7->8->NULL
Explanation : Here blocks of size 3 are
rotated towards right(as d is positive) 
by 1.

Input : 1->2->3->4->5->6->7->8->9->10->
               11->12->13->14->15->NULL, 
        k = 4 
        d = -1
Output : 2->3->4->1->6->7->8->5->10->11
             ->12->9->14->15->13->NULL
Explanation : Here, at the end of linked 
list, remaining nodes are less than k, i.e.
only three nodes are left while k is 4. 
Rotate those 3 nodes also by d.

https://www.geeksforgeeks.org/rotate-linked-list-block-wise/
 */

public class RotateLLBlockWise {

	public static void main(String[] args) 
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add( new Integer(1));
		list.add( new Integer(2));
		list.add( new Integer(3));
		list.add( new Integer(4));
		list.add( new Integer(5));
		list.add( new Integer(6));
		list.add( new Integer(7));
		list.add( new Integer(8));
		list.add( new Integer(9));

		list.printAllNodes();

		rotateLLBlockWise(list);
	}

	private static void rotateLLBlockWise(LinkedList<Integer> list) 
	{
		System.out.println("\nEnter Block size:");

		Scanner input = new Scanner( System.in );
		int blockSize = input.nextInt();

		System.out.print( "Enter rotation value: " );
		int rotate = input.nextInt();

		this is left


		ListNode blockHead = list.head();
		int j = 0;

		while(true)
		{
			System.out.println("Block Head:" + blockHead.data);

			
			if(blockHead == null)
				break;
			
			rotateBlock(blockHead,blockSize,rotate);
			
			

			blockHead = getBlockHead(blockHead,blockSize);

		
		}

		printAllNodes(blockHead); 

		
	}

	private static void rotateBlock(ListNode blockHead, int blockSize, int rotate)
	{
		// TODO Auto-generated method stub
		int i = 0;
		int nodeCountInBlock = 0;
		while(i < rotate)
		{
			ListNode curr = blockHead;
			ListNode prev = curr;

			while(curr.next != null && nodeCountInBlock < blockSize)
			{
				prev = curr;
				curr = curr.next;

				nodeCountInBlock ++;
			}

			prev.next = curr.next;
			curr.next = blockHead;
			blockHead = curr;

			i++;
		}
	}

	private static ListNode getBlockHead(ListNode blockHead, int blockSize)
	{
		if(blockHead == null)
			return null;
		
		ListNode node = blockHead;
		
		for(int i =0 ; i < blockSize && node.next != null ; i++)
		{
			node = node.next;
		}
		
		return node;
	}

	public static void printAllNodes(ListNode head)
	{

		for(ListNode current = head;current!= null ; current = current.next)
		{
			System.out.print(current.data);
			System.out.print("--->");

		}
		System.out.print("null\n");
	}

}
