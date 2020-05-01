package tree.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tree.util.BinarySearchTree;
import tree.util.TreeNode;

public class NonRecursivePreOrder
{

	public static void main(String[] args)
	{
		TreeNode root = createBinarySearchTree();

		System.out.println("\n\t PreOrder recursive traversal : ");
		printTree(root);

		// System.out.println("\n\t isBST --> :" + isBST(root));

		System.out.println("\n\t PreOrder non recursive traversal : ");

		printNonRecursivePreOrder(root);

	}

	/*
	 * private static void printNonRecursivePreOrder(TreeNode root) { if (root
	 * == null) return;
	 * 
	 * List<TreeNode> stack = new LinkedList<TreeNode>();
	 * 
	 * stack.add(root);
	 * 
	 * while (true) { TreeNode current = stack.get(stack.size() - 1); if
	 * (current == null) { stack.remove(stack.size() - 1); break; }
	 * System.out.println(stack.get(stack.size() - 1).getData());
	 * 
	 * // TreeNode current = ; stack.add(stack.get(stack.size() - 1).getLeft());
	 * 
	 * } System.out.println("Stack size: " + stack.size());
	 * 
	 * while (stack.size() > 0) { TreeNode current = stack.get(stack.size() -
	 * 1); stack.remove(stack.size() - 1);
	 * 
	 * if(current.getLeft()!= null) {
	 * System.out.println(current.getRt().getData());
	 * 
	 * stack.add(stack.get(stack.size() - 1));
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

	private static void printNonRecursivePreOrder(TreeNode node)
	{
		if (node == null)
			return;

		List<TreeNode> stack = new LinkedList<TreeNode>();

		while(true)
		{
			while(node != null)
			{
				System.out.println(node.getData());
				stack.add(node);
				node = node.getLeft();
			}
			if(stack.size() <= 0)
				break;
			
			node = stack.remove(stack.size() - 1).getRt();
		}
	}
	private static void printNonRecursivePreOrder_ShadyCode(TreeNode node)
	{
		if (node == null)
			return;

		List<TreeNode> stack = new LinkedList<TreeNode>();

		stack.add(node);
		System.out.println(node.getData());

		while (true)
		{
			if (stack.size() <= 0)
				break;

			TreeNode current = stack.get(stack.size() - 1);
			if (current.getLeft() != null)
			{
				System.out.println(current.getLeft().getData());
				stack.add(current.getLeft());
			}
			else if (current.getRt() != null)
			{
				stack.remove(stack.size() - 1);
				System.out.println(current.getRt().getData());

				stack.add(current.getRt());
			}
			else
			{
				stack.remove(stack.size() - 1);
				if (stack.size() > 0)
				{
					TreeNode parent = stack.remove(stack.size() - 1);
					if (parent.getRt() != null)
					{
						System.out.println(parent.getRt().getData());
						stack.add(parent.getRt());
					}
				}
				
				

			}
			
			if(stack.size() ==1 && stack.get(0).getData() == node.getData())
			{
				TreeNode p = stack.remove(stack.size() - 1);

				if (p.getRt() != null)
				{
					System.out.println(p.getRt().getData());

					stack.add(p.getRt());
				}

			}

		}
	}

	private static boolean isBST(TreeNode root)
	{
		if (root == null)
			return true;

		if (root.getLeft() != null && !(root.getLeft().getData() < root.getData()))
			return false;

		if (root.getRt() != null && !(root.getRt().getData() >= root.getData()))
			return false;

		if (root.getLeft() == null && root.getRt() == null)
			return true;

		return isBST(root.getLeft()) && isBST(root.getRt());

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

	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}

}
