package practice.imp;

/**
 * 
Rearrange a Linked List in Zig-Zag fashion

Given a linked list, rearrange it such that converted list should be of the form a < b > c < d > e < f ..
 where a, b, c.. are consecutive data node of linked list.

Examples :

Input:  1->2->3->4
Output: 1->3->2->4 

Input:  11->15->20->5->10
Output: 11->20->5->15->10
https://www.geeksforgeeks.org/linked-list-in-zig-zag-fashion/
 * @author ajinkyab
 *
 *
 * A simple approach to do this, is to sort the linked list using merge sort and then swap alternate, 
 *  but that requires O(n Log n) time complexity. Here n is number of elements in linked list.
 *  
 *  An efficient approach which requires O(n) time is, using a single scan similar to bubble sort 
 *  and then maintain a flag for representing which order () currently we are.
 *   If the current two elements are not in that order then swap those elements otherwise not.


 */
public class ZigZagLL
{

	/* Link list Node */
	static class Node  
	{  
	    int data;  
	    Node next;  
	} 
	static Node head = null; 
	static int temp = 0; 
	  
	// This function distributes  
	// the Node in zigzag fashion  
	static void zigZagList(Node head)  
	{  
	    // If flag is true, then  
	    // next node should be greater  
	    // in the desired output.  
	    boolean flag = true;  
	  
	    // Traverse linked list starting from head.  
	    Node current = head;  
	    while (current != null && current.next != null)  
	    {  
	        if (flag == true) /* "<" relation expected */
	        {  
	            /* If we have a situation like A > B > C  
	            where A, B and C are consecutive Nodes  
	            in list we get A > B < C by swapping B  
	            and C */
	            if (current != null &&  
	                current.next != null &&  
	                current.data > current.next.data)  
	            { 
	                    temp = current.data; 
	                    current.data = current.next.data; 
	                    current.next.data = temp; 
	            }  
	        }  
	        else /* ">" relation expected */
	        {  
	            /* If we have a situation like A < B < C where  
	            A, B and C are consecutive Nodes in list we  
	            get A < C > B by swapping B and C */
	            if (current != null && 
	                current.next != null &&  
	                current.data < current.next.data)  
	            { 
	                temp = current.data; 
	                current.data = current.next.data; 
	                current.next.data = temp; 
	            }  
	        }  
	  
	        current = current.next;  
	          
	        /* flip flag for reverse checking */
	        flag = !(flag);  
	    }  
	}  
	  
	/* UTILITY FUNCTIONS */
	/* Function to push a Node */
	static void push( int new_data)  
	{  
	    /* allocate Node */
	    Node new_Node = new Node();  
	  
	    /* put in the data */
	    new_Node.data = new_data;  
	  
	    /* link the old list off the new Node */
	    new_Node.next = (head);  
	  
	    /* move the head to point to the new Node */
	    (head) = new_Node;  
	}  
	  
	/* Function to print linked list */
	static void printList(Node Node)  
	{  
	    while (Node != null)  
	    {  
	        System.out.print(Node.data + "->");  
	        Node = Node.next;  
	    }  
	    System.out.println("NULL");  
	}  
	  
	/* Driver code*/
	public static void main(String[] args)  
	{  
	    /* Start with the empty list */
	    //Node head = null;  
	  
	    // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1  
	    // answer should be -> 3 7 4 8 2 6 1  
	    push(1);  
	    push(2);  
	    push(6);  
	    push(8);  
	    push( 7);  
	    push( 3);  
	    push( 4);  
	  
	    System.out.println("Given linked list ");  
	    printList(head);  
	  
	    zigZagList(head);  
	  
	    System.out.println("Zig Zag Linked list ");  
	    printList(head);  
	} 

}
