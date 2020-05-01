package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * @author ajinkyab
 *https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 *
 *The diameter of a tree (sometimes called the width) is the number of nodes on the longest path
 * between two end nodes. The diagram below shows two trees each with diameter nine, the leaves 
 * that form the ends of a longest path are shaded (note that there is more than one path in each 
 * tree of length nine, but no path longer than nine nodes).

solution: 
* the diameter of T’s left subtree
* the diameter of T’s right subtree
* the longest path between leaves that goes through the root of T (this can
*  be computed from the heights of the subtrees of T) 
 */
public class MaxDiameterOfTree
{

	 static int diameter(TreeNode root) 
	    { 
	        /* base case if tree is empty */
	        if (root == null) 
	            return 0; 
	  
	        /* get the height of left and right sub trees */
	        int lheight = height(root.left); 
	        int rheight = height(root.rt); 
	  
	        /* get the diameter of left and right subtrees */
	        int ldiameter = diameter(root.left); 
	        int rdiameter = diameter(root.rt); 
	  
	        /* Return max of following three 
	          1) Diameter of left subtree 
	         2) Diameter of right subtree 
	         3) Height of left subtree + height of right subtree + 1 */
	        return Math.max(lheight + rheight + 1, 
	                        Math.max(ldiameter, rdiameter)); 
	  
	    } 
	  
	  
	    /*The function Compute the "height" of a tree. Height is the 
	      number f nodes along the longest path from the root node 
	      down to the farthest leaf node.*/
	    static int height(TreeNode node) 
	    { 
	        /* base case tree is empty */
	        if (node == null) 
	            return 0; 
	  
	        /* If tree is not empty then height = 1 + max of left 
	           height and right heights */
	        return (1 + Math.max(height(node.left), height(node.rt))); 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        /* creating a binary tree and entering the nodes */
	    	TreeNode root=	TreeUtil.createTree();
	  
	        System.out.println("The diameter of given binary tree is : "
	                           + diameter(root)); 
	    } 
	

}
