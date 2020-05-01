package tree.bst;

import java.util.Scanner;

import tree.util.BinarySearchTree;
import tree.util.TreeNode;

/**
 * Find an efficient algorithm to convert Binary Search Tree into Circular Ordered Doubly
linked list.
        Input:  13
               /  \
              9   16
             / \ / \
            5 10 14 18
    Output: 5 <-> 9 <-> 10 <-> 13 <-> 14 <-> 16 <-> 18
 * @author ajinkyab
 *
 */
public class BSTTOList
{

	public static void main(String[] args)
	{
		TreeNode root = createBinarySearchTree();

		System.out.println("Tree Inorder traversal :");;

		 printTree(root);

		TreeNode head = findHead(root);

		System.out.println("\nHead node is :" +   head.getData());
		System.out.println("root node is :" +  root.getData());

		TreeNode last = covertBSTToList(head,root);

		System.out.println("last node is :" +  + last.getData());

		
		System.out.println("\nLinked List forward traversal :");;

		for(TreeNode current = head ; current!= null ;current= current.getRt())
		{
			System.out.print(current.getData() + ",");
			//if(current.getData() ==last.getData())
			//	break;
		}
		System.out.println("\nLinked List backward traversal :");;

		for(TreeNode current = last ; current!= null ;current= current.getLeft())
		{
			System.out.print(current.getData() + ",");
			//if(current.getData() ==last.getData())
			//	break;
		}

	}

	private static void printTree(TreeNode root)
	{
		if (root == null)
			return ;

		printTree(root.getLeft());
		System.out.print(root.getData()+",");


		printTree(root.getRt());


	}

	private static TreeNode covertBSTToList(TreeNode current, TreeNode node)
	{
		if (node == null)
			return current; 


		current= covertBSTToList(current,node.getLeft());

		if(current.getData() == node.getData())
		{
			System.out.println("Head node found :" + node.getData());
		}
		else
		{
			current.setRt(node);
			node.setLeft(current);
		}
		current = node;

	//	System.out.println("New current is: -->"+ current.getData());
		current = covertBSTToList(current,node.getRt());		

		return current;


	}


	private static TreeNode findHead(TreeNode root)
	{
		if(root== null)
			return null;


		TreeNode head = findHead(root.getLeft());
		if(head == null)
			return root;

		else
			return head;
	}

	private static TreeNode createBinarySearchTree()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Nodes : ");
		int noOfNodes = scan.nextInt();

		System.out.println("Enter Min Range : ");
		int minRange = scan.nextInt();

		System.out.println("Enter Max. Range : ");
		int maxRange = scan.nextInt();
		return (TreeNode) new BinarySearchTree(noOfNodes, minRange, maxRange).createBinarySearchTree();

	}


}
