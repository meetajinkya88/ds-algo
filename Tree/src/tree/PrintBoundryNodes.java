package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * @author ajinkyab
 *
 *https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 *
 *Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the root.
 * For example, boundary traversal of the following tree is “20 8 4 10 14 25 22”


  Solution: 
We break the problem in 3 parts:
1. Print the left boundary in top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…..2.1 Print all leaf nodes of left sub-tree from left to right.
…..2.2 Print all leaf nodes of right subtree from left to right.
3. Print the right boundary in bottom-up manner.

We need to take care of one thing that nodes are not printed again. 
e.g. The left most node is also the leaf node of the tree.
 */
public class PrintBoundryNodes
{

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		
		System.out.print("\n \n Printing all the boundry nodes anti clockwise: ");
		printBoundryNodes(root);
	}

	private static void printBoundryNodes(TreeNode root)
	{
		if(root == null)
			return;
		else
			System.out.print(" " + root.getData());
		
		System.out.print("\n\n Printing Left Subtree Boundry Nodes: ");
		printLeftBoundryNodes(root.getLeft());
		
		System.out.print("\n\n Printing Leaf Nodes: ");
		printLeafNodes(root);
		
		System.out.print("\n\n Printing Right Subtree Boundry Nodes: ");
		printRightBoundryNodes(root.getRt());
	}

	private static void printLeafNodes(TreeNode node)
	{
		if(node == null)
			return;
		
		printLeafNodes(node.getLeft());
		
		if(node.getLeft() == null && node.getRt() == null)
			System.out.print(" "  + node.getData());
		
		printLeafNodes(node.getRt());
	}

	private static void printRightBoundryNodes(TreeNode node)
	{
		if(node == null)
			return;
		
		if(node.getRt() != null)
		{
			printRightBoundryNodes(node.getRt());
			System.out.print(" " + node.getData());
			
		}
		
		if(node.getLeft() != null)
		{
			printRightBoundryNodes(node.getLeft());
			
			if(node.getRt() == null)
				System.out.print(" " + node.getData());
			
		}		
	}

	private static void printLeftBoundryNodes(TreeNode node)
	{
		if(node == null)
			return;
		
		if(node.getLeft() != null)
		{
			System.out.print(" " + node.getData());
			printLeftBoundryNodes(node.getLeft());
			
		}
		
		if(node.getRt() != null)
		{
			if(node.getLeft() == null)
				System.out.print(" " + node.getData());
			printLeftBoundryNodes(node.getRt());
		}
	
		
	}
	

}
