package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * https://www.geeksforgeeks.org/merge-two-binary-trees-node-sum/
 * @author ajinkyab
 *  
Merge Two Binary Trees by doing Node Sum (Recursive and Iterative)

Given two binary trees. We need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the non-null node will be used as the node of new tree.

Example:

Input: 
     Tree 1            Tree 2                  
       2                 3                             
      / \               / \                            
     1   4             6   1                        
    /                   \   \                      
   5                     2   7                  

Output: Merged tree:
         5
        / \
       7   5
      / \   \ 
     5   2   7

 */
public class MergeTwoTrees
{

	public static void main(String[] args)
	{
		TreeNode root1 = TreeUtil.createTree();
		
		System.out.println("Inorder Traversal of tree1:");
		TreeUtil.printInorderTree(root1);
		
		System.out.println("\n ");
		TreeNode root2 = TreeUtil.createTree();
		
		System.out.println("\n ");

		System.out.println("Inorder Traversal of tree2:");
		TreeUtil.printInorderTree(root2);
		
		TreeNode megeNode = null;
		megeNode = mergeTrees(root1,root2,megeNode);

		System.out.println("\n Inorder Traversal of merge tree:");
		TreeUtil.printInorderTree(megeNode);
	
	}

	private static TreeNode mergeTrees(TreeNode node1, TreeNode node2, TreeNode mergeNode)
	{
		if(node1 == null && node2 == null)
			return null;
		
		if(node1 != null && node2 != null)
			mergeNode = new TreeNode(node1.data + node2.data);
		
		else if(node1 != null && node2 == null)
			mergeNode = new TreeNode(node1.data);
		
		else if(node2 != null && node1 == null)
			mergeNode = new TreeNode(node2.data);
		
		mergeNode.setLeft(mergeTrees((node1 != null ? node1.left : null) ,(node2 != null ? node2.left : null) ,null));
		mergeNode.setRt(mergeTrees((node1 != null ? node1.rt : null) ,(node2 != null ? node2.rt : null) ,null));

		return mergeNode;
	}

	

}
