package practice.imp;
import java.util.Stack;

import practice.LinkedList;
import practice.ListNode;

/**
 * 
 * @author ajinkyab
 *  
 *   We need to reverse the link list using iterative approach
 *  https://www.youtube.com/watch?v=sYcOK51hl-A&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=9
 *  
 *  Recursive approach
 *  	
 * @param <T>
 */

public class ReverseLL<T> {

	protected static ListNode head = null;
	public static <T> void main(String[] args) 
	{

		LinkedList<T> list = new LinkedList<T>();
		list.add((T) new Integer(1));
		list.add((T) new Integer(2));
		list.add((T) new Integer(3));
		//list.add((T) new Integer(4));
		//list.add((T) new Integer(5));

	
		list.printAllNodes();
		list.printHeadNode();
		list.printLastNodel();
		
		System.out.println("Reverse Linked List Iterative:");
		reverseLinkListIterative(list);
		
		list.printAllNodes();

		System.out.println("Reverse Linked List Recursive:");
		reverseLinkListRecursive(list);
		
		list.printAllNodesRecursive();

		System.out.println("Reverse Linked List Iterative Using stack:");
		reverseLinkListIterativeUsingStack(list);

		list.printAllNodesRecursive();

	}

	private static<T> void reverseLinkListIterativeUsingStack(LinkedList<T> list) 
	{
		Stack<ListNode<T>> stack = new Stack<ListNode<T>>();
		ListNode<T> head , curr ;
		head = list.head();
		curr = head;
		while(curr.next != null)
		{
			stack.push(curr);
			curr = curr.next;
		}
		head = curr;
		while(!stack.isEmpty())
		{
			ListNode<T> node = stack.pop();
			curr.next = node;
			node.next = null;
			curr= node;
			
		}
		list.setHead(head);
	}

	private static<T> void reverseLinkListRecursive(LinkedList<T> list) 
	{

		ListNode<T> head = reverseLinkListRecursive2(list.head());
		list.setHead(head);

	}

	private static<T> ListNode<T> reverseLinkListRecursive2(ListNode<T> curr) 
	{
		if(curr.next == null)
			return curr;
		
		ListNode<T> head = null;
		head = reverseLinkListRecursive2(curr.next);
		
		curr.next.next = curr;
		curr.next = null;
		
		return head;
	}

	

	private static <T> void reverseLinkListIterative(LinkedList<T> list)
	{
		ListNode<T> head = list.head();
		ListNode<T> curr,prev, next ;

		if(head ==null || head.next == null)
			return;

 		curr = head;
		prev = null;
		next = curr.next;
		while(curr != null)
		{
			curr.next = prev;
			prev = curr;
			curr = next;
			
			if(curr != null)
				next = curr.next;
		}
		list.setHead(prev);

	}

	

}
