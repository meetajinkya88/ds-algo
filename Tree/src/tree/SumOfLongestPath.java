package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * https://www.geeksforgeeks.org/sum-nodes-longest-path-root-leaf-node/
 * 
 * 
Sum of nodes on the longest path from root to leaf node

Given a binary tree containing n nodes. The problem is to find the sum of all nodes on the longest path 
from root to leaf node. If two or more paths compete for the longest path, then the path having maximum 
sum of nodes is being considered.
 *  Examples:

Input : Binary tree:
        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3    
      /
     6
Output : 13

        4        
       / \       
      2   5      
     / \ / \     
    7  1 2  3 
      /
     6

The highlighted nodes (4, 2, 1, 6) above are 
part of the longest root to leaf path having
sum = (4 + 2 + 1 + 6) = 13

Approach: Recursively find the length and sum of nodes of each root to leaf path 
and accordingly update the maximum sum.
 * @author ajinkyab
 *
 */
public class SumOfLongestPath
{

	static int maxLevel = 0 ;
	static int maxSum = 0;
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		findSumOfLongestPath(root,0,0);
		
		System.out.println("\n Longest Level: " + maxLevel);
		System.out.println("\n Longest Level Sum: " +maxSum);
	}
	private static void findSumOfLongestPath(TreeNode node, int currentLevel, int currentSum)
	{
		if(node == null)
		{
			if(currentLevel >= maxLevel)
			{
				maxLevel = currentLevel;
				
				if(currentSum > maxSum)
					maxSum = currentSum;
			}
			
			return;
		}
		
		findSumOfLongestPath(node.left,currentLevel+1,currentSum + node.getData());
		findSumOfLongestPath(node.rt,currentLevel+1,currentSum + node.getData());

	}

}
