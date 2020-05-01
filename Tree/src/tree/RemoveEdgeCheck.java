package tree;

import tree.util.TreeNode;

/**
 * 
 * 
Check if removing an edge can divide a Binary Tree in two halves

Given a Binary Tree, find if there exist edge whose removal creates two trees of equal size.

https://www.geeksforgeeks.org/check-if-removing-an-edge-can-divide-a-binary-tree-in-two-halves/
 * @author ajinkyab
 *
 */
public class RemoveEdgeCheck
{

	public static void main(String[] args)
	{
		 TreeNode root = new TreeNode(); 
	        root = new TreeNode(5); 
	        root.left = new TreeNode(1); 
	        root.rt = new TreeNode(6); 
	        root.left.left = new TreeNode(3);
	        root.left.left.rt = new TreeNode(2); 
	        root.rt.left = new TreeNode(7); 
	        root.rt.rt = new TreeNode(4); 
	        root.rt.rt.left = new TreeNode(9); 

	        if(removeEdgeCheck(root)) 
	            System.out.println("YES"); 
	        else
	            System.out.println("NO"); 
	}

	/**
	 * First count number of nodes in whole tree. Let count of all nodes be n. Now traverse tree
	 *  and for every node, find size of subtree rooted with this node. Let the subtree size be s.
	 *   If n-s is equal to s, then return true, else false.
	 * @param root
	 * @return
	 */
	private static boolean removeEdgeCheck(TreeNode root)
	{
		int n =	countNodes(root);
		
		System.out.println("No of nodes are: " + n);
		return checkRemovableEdge(root,n);
	}

	private static boolean checkRemovableEdge(TreeNode node,int n)
	{
		if(node == null)
			return false;
		
		if(countNodes(node) == (n - countNodes(node)))
			return true;
		
		return checkRemovableEdge(node.left, n) || checkRemovableEdge(node.rt, n);
	}

	private static int countNodes(TreeNode node)
	{
		if(node == null)
			return 0 ;
	
		return countNodes(node.left) + countNodes(node.rt) +1;
	}

}
