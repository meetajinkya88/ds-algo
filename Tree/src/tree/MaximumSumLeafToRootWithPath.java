package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * https://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 * @author ajinkyab
 *
 *iven a Binary Tree, find the maximum sum path from a leaf to root. 
 *For example, in the following tree, there are three leaf to root paths 8->-2->10, -4->-2->10 and 7->10. 
 *The sums of these three paths are 16, 4 and 17 respectively. The maximum of them is 17 and the path 
 *for maximum is 7->10.

                  10
               /      \
             -2        7
           /   \     
          8     -4    

Expected output:
Following are the nodes on the maximum sum path
7 10
Sum of the nodes is 17
 */
public class MaximumSumLeafToRootWithPath
{
	static String maxSumPath = "";
	static int maxSum = 0;
	
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		maximumSumLeafToRootWithPath(root,0 , "");
		
		System.out.println("\n Max Sum Path : " + maxSumPath);
		System.out.println("\n Max Sum: " +maxSum);

	}

	private static void maximumSumLeafToRootWithPath(TreeNode node, int currentSum, String currentSumPath)
	{

		if(node == null)
			return;
		
		if(node.left == null && node.rt ==null)
		{
			currentSum += node.getData();
			currentSumPath += " " +  node.getData();
			if(maxSum < currentSum)
			{
				maxSum = currentSum;
				maxSumPath = currentSumPath;
			}
		}
		
		maximumSumLeafToRootWithPath(node.left, currentSum + node.getData(), currentSumPath + " " + node.getData());
		maximumSumLeafToRootWithPath(node.rt, currentSum + node.getData(), currentSumPath + " " + node.getData());

	}

}
