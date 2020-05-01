import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import tree.util.BinaryTree;
import tree.util.TreeNode;


/**
 *   Write an efficient function to display given binary tree in zig-zag order. What are the
time and space complexities of your solution?
Function prototype:
 void printTree(TreeNode t)
Input:  3
      /   \
     4     7
    / \   / \
   5   1 6   8
Output: 3 7 4 5 1 6 8


 * @author ajinkyab
 *
 */
public class ZigZagTraversal
{

	public static void main(String[] args)
	{
		TreeNode root = createTree();
		
		printTree(root);

		System.out.println("\n\t Printing Zig zag Level Order as follows :" );
		printZigZagTraversalNonRecursive(root);


	}
	private static void printZigZagTraversalNonRecursive(TreeNode root)
	{
		
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();

		
		
		stack1.push(root);
		while(stack1.size() != 0 || stack2.size() != 0)
		{
			while(stack1.size()!=0)
			{
				TreeNode node = stack1.pop();
				System.out.print(node.getData() + ",");
				
				if(node.getLeft() != null)
					stack2.push(node.getLeft());
				if(node.getRt() != null)
					stack2.push(node.getRt());
		
			}
			while(stack2.size() != 0)
			{
				TreeNode node = stack2.pop();
				System.out.print(node.getData() + ",");
				
				
				if(node.getRt() != null)
					stack1.push(node.getRt());
				if(node.getLeft() != null)
					stack1.push(node.getLeft());
				
			}
		}
	}
	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}
	
	private static TreeNode createTree()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Nodes : ");
		int noOfNodes = scan.nextInt();

		System.out.println("Enter Min Range : ");
		int minRange = scan.nextInt();

		System.out.println("Enter Max. Range : ");
		int maxRange = scan.nextInt();
		return (TreeNode) new BinaryTree(noOfNodes, minRange, maxRange).createBinaryTree();

	}

}
