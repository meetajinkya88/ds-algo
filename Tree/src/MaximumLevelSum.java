import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

import tree.util.BinaryTree;
import tree.util.TreeNode;

/**
 * Given a binary tree, write an efficient function that returns the maximum
 * level sum. If tree is empty return false. Assume that all values in binary
 * tree are positive integers. What are the space and time complexities of your
 * solution? Function prototype:
 * 
 * int MaxLevelSum(TreeNode t) Input:
 *                     3 
 *                    / \
 *                   4   7
 *                  / \ / \ 
 *                  5 1 1 2
 * 
 * Output: 11
 * 
 * @author ajinkyab
 * 
 */
public class MaximumLevelSum
{

	public static void main(String[] args)
	{

		TreeNode root = createTree();

		printTree(root);

		maxLevelSum(root);

	}

	private static void maxLevelSum(TreeNode root)
	{
		Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
		ArrayList<Integer> levelArray = new ArrayList<Integer> ();
		int maxSum = 0;
		

		if (root == null)
		{
			System.out.println("Max level Sum is 0 at level 1");
			return;
		}

		queue.add(root);
		queue.add(getMarkerNode());

		while (true)
		{
			TreeNode node = queue.remove();
			
			
			if (node.getData() == -1)
			{
				
				levelArray.add(maxSum);
			
				if(queue.size() <= 0)
					break;
			
				maxSum = 0;
				queue.add(getMarkerNode());	
				continue;
			}
			
			maxSum = maxSum + node.getData();
			
			if(node.getLeft()!=null)
				queue.add(node.getLeft());
			
			if(node.getRt()!=null)
				queue.add(node.getRt());


		}
		
		int level = 1;
		for(int i : levelArray)
		{
			System.out.println("Sum of level " + level++ + " is :" + i);
		}

	}
	private static TreeNode getMarkerNode()
	{
		TreeNode markerNode = new TreeNode();
		markerNode.setData(-1);
		return markerNode;

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
