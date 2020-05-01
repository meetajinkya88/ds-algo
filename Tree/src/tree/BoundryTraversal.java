package tree;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class BoundryTraversal
{
	protected static StringBuffer buffer = new StringBuffer();
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
	
		printBoundryTraversal(root);
	}

	private static void printBoundryTraversal(TreeNode root)
	{
		TreeNode node = root;
		
		printLeftSubTreeWithoutLeaf(node);
		
		printLeafNodes(node);
		
		printRightSubTreeWithoutLeaf(node.getRt());
		
		System.out.println("Boundry Traversal Nodes are:" + buffer.toString());
	}


	private static void printLeftSubTreeWithoutLeaf(TreeNode node)
	{
		if(node == null)
			return;
		
		if(node.getLeft() == null && node.getRt() == null)
			return;
		
		buffer.append(node.getData() + " ");
		
		printLeftSubTreeWithoutLeaf(node.getLeft());
		
		
	}

	private static void printLeafNodes(TreeNode node)
	{
		if(node == null)
			return;
		
		if(node.getLeft() == null && node.getRt() == null)
			buffer.append(node.getData() + " ");
		
		printLeafNodes(node.getLeft());
		
		printLeafNodes(node.getRt());

	}
	
	private static void printRightSubTreeWithoutLeaf(TreeNode node)
	{
		if(node == null)
			return;
		
		if(node.getLeft() == null && node.getRt() == null)
			return;
	
		printRightSubTreeWithoutLeaf(node.getRt());

		buffer.append(node.getData() + " ");
		
	
		
	}
}
