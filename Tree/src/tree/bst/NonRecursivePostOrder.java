
package tree.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import tree.util.BinarySearchTree;
import tree.util.TreeNode;

public class NonRecursivePostOrder
{

	public static void main(String[] args)
	{
		TreeNode root = createBinarySearchTree();

		System.out.println("\n\t PostOrder recursive traversal : ");
		printTree(root);

		// System.out.println("\n\t isBST --> :" + isBST(root));

		System.out.println("\n\t PostOrder non recursive traversal : ");

		printNonRecursivePostOrder(root);

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

	private static void printNonRecursivePostOrder(TreeNode root)
	{
		if (root == null)
			return;

		List<TreeNode> stack = new LinkedList<TreeNode>();

		while (true)
		{
			while (root != null)
			{
				stack.add(root);
				root = root.getLeft();
			}

			if(stack.size() <= 0)
				break;
			
			root = stack.get(stack.size() - 1);
			
			if(root.getRt() == null)
				System.out.print(stack.remove(stack.size() - 1).getData()+ ",");
			
			 root = root.getRt();
			


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

		printTree(root.getLeft());
		printTree(root.getRt());
		System.out.print(root.getData()+ ",");

	}

}
