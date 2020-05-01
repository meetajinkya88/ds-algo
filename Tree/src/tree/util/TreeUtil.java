package tree.util;

import java.util.Scanner;


public class TreeUtil
{

	public static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}
	
	public static void printInorderTree(TreeNode root)
	{
		if (root == null)
			return;

		printInorderTree(root.getLeft());
		System.out.print(root.getData() + " ");
		printInorderTree(root.getRt());

	}
	
	public static void printPostOrderTree(TreeNode root)
	{
		if (root == null)
			return;

		printPostOrderTree(root.getLeft());
		printPostOrderTree(root.getRt());
		System.out.println(root.getData());

	}

	public static TreeNode createTree()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Nodes : ");
		int noOfNodes = scan.nextInt();

		System.out.println("Enter Min Range : ");
		int minRange = scan.nextInt();

		System.out.println("Enter Max. Range : ");
		int maxRange = scan.nextInt();
		
		//scan.close();
		return (TreeNode) new BinaryTree(noOfNodes, minRange, maxRange).createBinaryTree();

	}
	
	public static TreeNode createBinarySearchTree()
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
