package practice.imp;

import practice.LinkedList;
import practice.ListNode;
import practice.imp.ZigZagLL.Node;

/**
 * 
 * @author ajinkyab
 *
 * https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 * 
Add two numbers represented by linked lists | Set 2

Given two numbers represented by two linked lists, write a function that returns sum list. 
The sum list is linked list representation of addition of two input numbers. 
It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).

Example

Input:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405

 */
public class AddTwoNumbers
{
	public static ListNode resultNode = null;

	public static void main(String[] args) 
	{
		LinkedList list1= new LinkedList();
		LinkedList list2 = new LinkedList();

		list1.add(9);
		list1.add(9);
		list1.add(9);


		list2.add(9);
		list2.add(9);
		list2.add(9);

		

		System.out.print("List1: ");
		list1.printAllNodesRecursive();

		System.out.print("List2: ");
		list2.printAllNodesRecursive();

		addLLs(list1,list2);

	}

	private static void addLLs(LinkedList list1, LinkedList list2)
	{
		int length1 = getLength(list1);
		int length2 = getLength(list2);
		int diff =0;
		if(length1 > length2)
		{
			diff = length1 - length2;
			while(diff > 0)
			{
				prependZeroValueNode(list2);
				diff --;
			}
		}
		else
		{
			diff = length2 - length1;
			while(diff > 0)
			{
				prependZeroValueNode(list1);
				diff --;
			}
		}
		System.out.print("Modified List1: ");
		list1.printAllNodesRecursive();

		System.out.print("Modified List2: ");
		list2.printAllNodesRecursive();

		//ListNode resultNode = getListNode();
		int carry = auxAddLLs(list1.head(),list2.head());

		if(carry > 0)
		{
			ListNode newNode = getListNode();
			newNode.data = 1;			
			if(resultNode != null)
				newNode.next = resultNode;
			resultNode = newNode;
		}
		printList(resultNode);
	}
	/* Function to print linked list */
	static void printList(ListNode Node)  
	{  
		while (Node != null)  
		{  
			System.out.print(Node.data + "->");  
			Node = Node.next;  
		}  
		System.out.println("null");  
	}  
	private static void prependZeroValueNode(LinkedList list) 
	{
		ListNode node = getListNode();
		node.data = 0;
		node.next = list.head();
		list.setHead(node);
	}

	private static int getLength(LinkedList list)
	{
		ListNode curr = list.head();
		int length = 0;
		while(curr != null)
		{
			curr = curr.next;
			length ++;
		}
		return length;
	}


	private static int auxAddLLs(ListNode curr1, ListNode curr2) 
	{
		if(curr1 == null && curr2== null)
			return 0;

		int carry = auxAddLLs(curr1.next, curr2.next);

		int sum = (Integer)curr1.data + (Integer)curr2.data + carry;

		if(sum >= 10)
		{
			sum = sum % 10;
			carry = 1;
		}
		else
			carry= 0;

		ListNode newNode = getListNode();
		newNode.data = sum;
		if(resultNode != null)
			newNode.next = resultNode;
		
		resultNode = newNode;
	
		
//		System.out.println("curr1 data: " + curr1.data);
//		System.out.println("curr2 data: " + curr2.data);
//		System.out.println("sum : " + sum);
//		System.out.println("2.isCarry: " + carry);
//		System.out.print("result List: ");
		printList(resultNode);

		return carry;
	}

	private static ListNode getListNode() 
	{
		ListNode node = new ListNode(-1);
		node.next = null;
		return node;
	}

}
