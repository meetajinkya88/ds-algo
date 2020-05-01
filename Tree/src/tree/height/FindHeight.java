package tree.height;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import tree.util.BinaryTree;
import tree.util.TreeNode;

public class FindHeight
{

	public static void main(String[] args)
	{
		TreeNode root = createTree();

		printTree(root);

		System.out.println("\n\t Height of the tree with Recursion is :" + findHeightOfTreeWithRecusrion(root));

		System.out.println("\n\t Height of the tree withiout Recursion is (Using queue) :" + findHeightOfTreeWithoutRecusrion(root));

	}

	public static int findHeightOfTreeWithoutRecusrion(TreeNode node)
	{
		if (node == null)
			return 0;

		int height = 0;
		Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);

		queue.add(node);

		queue.add(getMarkerNode());

		while (true)
		{
			TreeNode current = queue.remove();
			if (current.getData() == -1)
			{
				if (queue.size() > 0)
				{
					height++;
					queue.add(getMarkerNode());
				} 
				else
					break;
			} else
			{
				if (current.getLeft() != null)
				{
					queue.add(current.getLeft());
				}
				if (current.getRt() != null)
				{
					queue.add(current.getRt());
				}
			}
		}
		return height + 1;
	}

	private static TreeNode getMarkerNode()
	{
		TreeNode markerNode = new TreeNode();
		markerNode.setData(-1);
		return markerNode;

	}

	public static int findHeightOfTreeWithRecusrion(TreeNode node)
	{
		if (node == null)
			return 0;

		if (node.getLeft() == null && node.getRt() == null)
			return 1;

		int lstHeight = findHeightOfTreeWithRecusrion(node.getLeft());
		int rstHeight = findHeightOfTreeWithRecusrion(node.getRt());

		return 1 + Math.max(lstHeight, rstHeight);

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
