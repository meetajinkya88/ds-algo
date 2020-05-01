import java.util.ArrayList;

import tree.height.FindHeight;
import tree.util.TreeNode;

/**
 * 
 * Given a tree of n elements as a parent array A i.e., A[i] contains the parent
 * of ith element, write an efficient function to find the depth of tree. The
 * value of -1 in an array indicates there is no parent for that indexed
 * element. What are the time and space complexities of your solution? Function
 * Prototype: int FindDepth(int a[], int n) Input: 2 5 1 2 0 -1 1 5 [parent of 0
 * is 2, parent of 1 is 5, etc.,] Output: 4
 * 
 * @author ajinkyab
 * 
 */
public class DepthOfTree
{

	public static void main(String[] args)
	{
		int[] in = new int[8];

		in[0] = 2;
		in[1] = 5;
		in[2] = 1;
		in[3] = 2;
		in[4] = 0;
		in[5] = -1;
		in[6] = 1;
		in[7] = 5;

		/*
		 * in[0] = 1; in[1] = 2; in[2] = -1; in[3] = 2;
		 */
		TreeNode root = createBinaryTree(in);

		printTree(root);
		
		findDepth(root);
	}

	private static void findDepth(TreeNode root)
	{

		System.out.println("Find depth with recusrion: " + (FindHeight.findHeightOfTreeWithRecusrion(root) - 1));
		System.out.println("Find depth without recusrion: " + (FindHeight.findHeightOfTreeWithoutRecusrion(root)-1));

	}

	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}

	private static TreeNode createBinaryTree(int[] in)
	{
		TreeNode root = null;

		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
		for (int i = 0; i < in.length; i++)
		{
			// System.out.println("Attaching child node " + i +
			// " under parent node : " + in[i]);
			TreeNode parent = null;
			TreeNode child = null;

			System.out.println("Checking node with Parent Data : " + in[i]);

			if (in[i] == -1 && root == null)
				root = returnNodeIfPresent(nodeList, i);

			else
			{

				parent = returnNodeIfPresent(nodeList, in[i]);

				if (parent == null)
				{
					System.out.println("Node retrived is null for parentdata :" + in[i] + " and child data : " + i);
					parent = new TreeNode(in[i]);
					nodeList.add(parent);
				}
				child = returnNodeIfPresent(nodeList, i);

				if (child == null)
				{
					child = new TreeNode(i);
				}

				if (parent.getLeft() == null)
					parent.setLeft(child);
				else if (parent.getRt() == null)
					parent.setRt(child);

			}
		}

		return root;
	}

	private static TreeNode returnNodeIfPresent(ArrayList<TreeNode> nodeList, int parentData)
	{
		TreeNode node = null;
		// System.out.println("Parent Data is : " + parentData);

		for (TreeNode current : nodeList)
		{
			node = traverseAndGetNode(current, parentData);

			if (node != null)
			{
				System.out.println("Found node with data :" + node.getData());
				return node;
			}
		}

		return node;
	}

	private static TreeNode traverseAndGetNode(TreeNode current, int parentData)
	{

		if (current == null)
			return current;

		//System.out.println("current Data is : " + current.getData());

		// System.out.println("Parent Data is : " + parentData);

		if (current.getData() == parentData)
		{
		//	System.out.println("Match Found for data : " + parentData);
			return current;
		} else
		{
			TreeNode foundNode = traverseAndGetNode(current.getLeft(), parentData);
			if (foundNode == null)
				foundNode = traverseAndGetNode(current.getRt(), parentData);

			return foundNode;
		}

	}

}
