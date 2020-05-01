package tree.bst;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * https://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/
 * @author ajinkyab
 *The second largest element is second last element in inorder traversal and second element in reverse
 *  inorder traversal. We traverse given Binary Search Tree in reverse inorder and keep track of 
 *  counts of nodes visited. Once the count becomes 2, we print the node.
 */
public class Find2ndLargest
{
	static int nodesVisited = 0;
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createBinarySearchTree();

		TreeUtil.printInorderTree(root);
		
		System.out.println("2nd Largest Node is:" + secondLargestNode(root,0));

	}
	private static int secondLargestNode(TreeNode node,int secondLargestNode)
	{
		if(node == null || nodesVisited == 2)
		return secondLargestNode;
		
		secondLargestNode = secondLargestNode(node.rt, secondLargestNode);
		
		nodesVisited ++;
		if(nodesVisited == 2)
			secondLargestNode = node.data;
		
		return secondLargestNode(node.left,secondLargestNode);
	}

}
