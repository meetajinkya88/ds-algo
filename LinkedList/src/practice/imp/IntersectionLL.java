package practice.imp;

/**
 *  https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
 *  
Write a function to get the intersection point of two Linked Lists.

There are two singly linked lists in a system. By some programming error, the end node of one of the linked list got linked to the second list, forming an inverted Y shaped list. Write a program to get the point where two linked list merge.

Y ShapedLinked List
 * @author ajinkyab
 *
 */
public class IntersectionLL 
{
	static Node head1, head2; 

	static class Node { 

		int data; 
		Node next; 

		Node(int d) { 
			data = d; 
			next = null; 
		} 
	} 

	public static void main(String[] args)
	{
		//		// Method (Using difference of node counts)
		//		1) Get count of the nodes in the first list, let count be c1.
		//	2) Get count of the nodes in the second list, let count be c2.
		//	3) Get the difference of counts d = abs(c1 – c2)
		//	4) Now traverse the bigger list from the first node till d nodes so that from here onwards 
		//       both the lists have equal no of nodes.
		//	5) Then we can traverse both the lists in parallel till we come across a common node. 
		//       (Note that getting a common node is done by comparing the address of the nodes)
//		Time Complexity: O(m+n)
//		Auxiliary Space: O(1)
		
		IntersectionLL list = new IntersectionLL();
		// creating first linked list 
		list.head1 = new Node(3); 
		list.head1.next = new Node(6); 
		list.head1.next.next = new Node(15); 
		list.head1.next.next.next = new Node(15); 
		list.head1.next.next.next.next = new Node(30); 

		// creating second linked list 
		list.head2 = new Node(10); 
		list.head2.next = new Node(17); 
		list.head2.next.next = new Node(35); 

		System.out.println("The node of intersection is " + list.getNode()); 


		// Alternate method (Make circle in first list)
//		1. Traverse the first linked list(count the elements) and make a circular linked list. 
//		(Remember the last node so that we can break the circle later on).
//		2. Now view the problem as finding the loop in the second linked list. So the problem is solved.
//		3. Since we already know the length of the loop(size of the first linked list) 
//		we can traverse those many numbers of nodes in the second list, and then start another 
//		pointer from the beginning of the second list. we have to traverse until they are equal, 
//		and that is the required intersection point.
//		4. remove the circle from the linked list.
//
//		Time Complexity: O(m+n)
//		Auxiliary Space: O(1)

	}

	private String getNode() 
	{
		Node curr1 = head1;
		Node curr2 = head2;
		int diff = 0;

		int count1= getCountNodes(curr1);
		int count2= getCountNodes(curr2);

		if(count1 == 0 || count2 == 0)
			return "-1";

		if(count1 > count2)
		{
			diff = count1 - count2;
			while(diff > 0)
			{
				curr1 = curr1.next;
				diff--;
			}
		}
		else 
		{
			diff = count2 - count1;
			while(diff > 0)
			{
				curr2 = curr2.next;
				diff --;
			}
		}

		return getIntersection(curr1,curr2);
	}

	private String getIntersection(Node curr1, Node curr2) 
	{
		while(curr1 != null && curr2 != null)
		{
			if(curr1.data==curr2.data)
				return curr1.data + "";

			curr1 = curr1.next;
			curr2= curr2.next;
		}
		return "-1";
	}

	private int getCountNodes(Node node)
	{
		int countNode = 0;
		if(node == null)
			return 0;
		while(node != null)
		{
			countNode ++;
			node= node.next;
		}
		return countNode;
	}

}
