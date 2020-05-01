package tree.singleChild;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import tree.util.BinaryTree;
import tree.util.TreeNode;

public class CountSingleChildNode
{

	public static void main(String[] args)
	{
		TreeNode root = createTree();

		printTree(root);

		System.out.println("\n\t Sinble node count of the tree with Recursion is :" + countSingleChildNodes(root));

		System.out.println("\n\t Sinble node count of the tree withiout Recursion is (Using queue) :" + countSingleChildNodesWithoutRecusrion(root));

	}

	private static int countSingleChildNodesWithoutRecusrion(TreeNode node)
	{

		if (node == null)
			return 0;

		int singleChildCount = 0;
		Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);

		queue.add(node);

		while (queue.size() > 0)
		{

			TreeNode current = queue.remove();

			if(current.getLeft() == null && current.getRt() == null)
				continue;
			
			if (current.getLeft() == null && current.getRt() != null)
			{
				System.out.println("Incrementing 1 for node " + current.getData() + " since left child is null");
				++singleChildCount;
				queue.add(current.getRt());
			}
			else if (current.getLeft() != null && current.getRt() == null)
			{
				System.out.println("Incrementing 1 for node " + current.getData() + " since rt child is null");
				++singleChildCount;
				queue.add(current.getLeft());

			} else
			{
				queue.add(current.getLeft());
				queue.add(current.getRt());

			}
		}

		return singleChildCount;

	}

	private static int countSingleChildNodes(TreeNode node)
	{
		if (node == null)
			return 0;

		if (node.getLeft() == null && node.getRt() == null)
			return 0;

		if (node.getLeft() == null && node.getRt() != null)
		{
			System.out.println("Incrementing 1 for node " + node.getData() + " since left child is null");
			return 1 + countSingleChildNodes(node.getRt());
		}
		if (node.getLeft() != null && node.getRt() == null)
		{
			System.out.println("Incrementing 1 for node " + node.getData() + " since rt child is null");

			return 1 + countSingleChildNodes(node.getLeft());
		}

		return countSingleChildNodes(node.getLeft()) + countSingleChildNodes(node.getRt());
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

	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}
}
