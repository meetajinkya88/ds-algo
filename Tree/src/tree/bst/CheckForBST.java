package tree.bst;

import java.util.Scanner;

import tree.util.BinarySearchTree;
import tree.util.TreeNode;

public class CheckForBST
{

	public static void main(String[] args)
	{
		TreeNode root = createBinarySearchTree();

		printTree(root);

		System.out.println("\n\t isBST --> :" + isBST(root));

	}

	private static boolean isBST(TreeNode root)
	{
		if (root == null)
			return true;
		
		
		if (root.getLeft()!= null && !(root.getLeft().getData() < root.getData()))
			return false;

		if (root.getRt() != null && !(root.getRt().getData() >= root.getData()))
			return false;

		if(root.getLeft() == null && root.getRt() == null)
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
