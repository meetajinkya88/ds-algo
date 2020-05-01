package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class ReverseLevelOrderTraversal
{

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
	
		printReverseOrderTraversal(root);

	}

	private static void printReverseOrderTraversal(TreeNode node)
	{
		if(node == null)
			return;
		
		
	}

}
