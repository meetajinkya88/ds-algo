package practice.imp;

import practice.LinkedList;
import practice.ListNode;

/**
 * https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 * 
 * Given a singly linked list of characters, write a function that returns true if the given list is palindrome, 
 * else false.

 * @author ajinkyab
 * @param <T>
 *
 */
public class CheckForPalindrome<T>
{
	protected static ListNode head = null;
	protected static ListNode left = null;

	@SuppressWarnings("unchecked")
	public static <T> void main(String[] args) 
	{

		LinkedList<T> list = new LinkedList<T>();
		list.add((T) new Character('a'));
		list.add((T) new Character('b'));
		list.add((T) new Character('a'));
		list.add((T) new Character('c'));
		list.add((T) new Character('a'));
		list.add((T) new Character('b'));
		list.add((T) new Character('a'));

//		list.add((T) new Character('n'));
//		list.add((T) new Character('i'));
//		list.add((T) new Character('t'));
//		list.add((T) new Character('i'));
//		list.add((T) new Character('n'));

		
		if(list == null || list.head() == null)
		{
			System.out.println("List is null..");
			return;
		}
		if(list.head().next == null)
		{
			System.out.println("List is Palindrome..");
			return;
		}
		list.printAllNodes();

//		Method1
//		This method takes O(n) time and O(1) extra space.
//		1) Get the middle of the linked list.
//		2) Reverse the second half of the linked list.
//		3) Check if the first half and second half are identical.
//		4) Construct the original linked list by reversing the second half again and attaching it back to the first half
//		Time Complexity: O(n)
//		Auxiliary Space: O(1)
		
		//method1(list);
		
		
		// Method 2
//		Use two pointers left and right. Move right and left using recursion and check for following in each recursive call.
//		1) Sub-list is palindrome.
//		2) Value at current left and right are matching.
//		If both above conditions are true then return true.
//		Time Complexity: O(n)
//		Auxiliary Space: O(n) if Function Call Stack size is considered, otherwise O(1).
//

		method2(list);
	
	}

	private static <T> void method2(LinkedList<T> list) 
	{
		left =  list.head();
		ListNode <T> curr = left;
		System.out.println("Linked List Palindrome is: " + isLLPalindrome(curr));
		
		
	}

	private static<T> boolean isLLPalindrome(ListNode<T> curr) 
	{
		if(curr == null)
			return false;
		boolean flag = isLLPalindrome(curr.next);
		
		if(!flag && curr.next != null)
			return false;
		
		if((((Character)left.data) - ((Character)(curr.data))) == 0)
			flag = true;
		else
			flag = false;
		
		left = left.next;
		
		return flag;
	}

	private static<T> void method1(LinkedList<T> list) 
	{
		ListNode<T> mid = findMid(list.head());
		reverse(mid,mid.next);
		list.printAllNodesRecursive();

		System.out.println("The Linked List Palindrome is :" + compare(list.head(),mid));

		reverse(mid,mid.next);
		list.printAllNodesRecursive();
		
	}

	private static <T> boolean compare(ListNode<T> head,ListNode<T> mid) 
	{

		ListNode<T> firstHalf = head;
		ListNode<T> secondHalf = mid.next;

		while( secondHalf != null)
		{
		//	System.out.println("1.FirstHalf: " + firstHalf.data);
		//	System.out.println("1.SecondHalf: " + secondHalf.data);

			if((((Character)firstHalf.data) - ((Character)(secondHalf.data))) != 0)
				return false;

			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		//	System.out.println("2.FirstHalf: " + firstHalf.data);
		//	System.out.println("2.SecondHalf: " + secondHalf.data);

		}

		return true;
	}

	private static <T> void reverse(ListNode<T> mid, ListNode<T> curr) 
	{
		if(curr.next ==null)
		{
			//	if(mid != null)
			mid.next = curr;
			return;
		}
		reverse(mid, curr.next);
		curr.next.next = curr;
		curr.next = null;
	}

	private static <T> ListNode<T> findMid(ListNode<T> head) 
	{
		ListNode<T> slow = head;
		ListNode<T> fast = head;
		while(true)
		{
		
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast.next == null || fast.next.next == null)
				break;
		}
		System.out.println("Mid Element is:" + slow);
		return slow;
	}

}
