package tree;

import javax.swing.RootPaneContainer;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * @author ajinkyab
 *
 * The diameter of a tree (sometimes called the width) is the number of nodes on the longest path between 
 * two end nodes. The diagram below shows two trees each with diameter nine, the leaves that form the ends 
 *  of a longest path are shaded (note that there is more than one path in each tree of length nine, but no path longer than nine nodes).
 *  
 *   https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */

public class DiameterBetweenNodes
{

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		
		System.out.println("Diameter is: " + findDiameter(root));
	}

	private static int findDiameter(TreeNode root)
	{
		
		if(root == null)
			return 0;
		
		int lh = getHeight(root.getLeft());
		int rh = getHeight(root.getRt());
		
		return 1 + lh+ rh;
	}

	private static int getHeight(TreeNode node)
	{
		if(node == null)
		return 0;
		
		int lh = 1 + getHeight(node.getLeft());
		int rh = 1 + getHeight(node.getRt());
		if(lh > rh)
			return lh;
		else 
			return rh;
	}

}
