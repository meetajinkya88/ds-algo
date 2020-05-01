package tree;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InorderTraversalWithoutRecursion
{

	protected static List<TreeNode> stack = new ArrayList<TreeNode>();
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		
		inorderTraversal(root);
	}

	protected static void push(TreeNode node)
	{
		stack.add(node);
	}
	protected static TreeNode pop()
	{
		if(stack != null && stack.size() > 0)
			return stack.remove(stack.size() -1);
		
		return null;
	}
	protected static boolean isStackEmpty()
	{
		return stack.isEmpty();
	}
	
	protected static TreeNode peek()
	{
		if(stack != null && stack.size() > 0)
			return stack.get(stack.size() -1);
		
		return null;
	}
	private static void inorderTraversal(TreeNode root)
	{
		TreeNode node = root;
		TreeNode popNode = null;
		boolean alreadyVisited = false;
		push(node);
		
		while(!isStackEmpty())
		{
			node = peek();
			if(node.getLeft() != null && !alreadyVisited)
			{
				push(node.getLeft());
				continue;
			}
			else
			{
				System.out.println("Tree Node: " + node.getData());
				popNode = pop();
				alreadyVisited = true;
				
				if(popNode.getRt() != null)
				{
					push(popNode.getRt());
					alreadyVisited = false;
					continue;
				}
				
			}
			
			
			
		}
	}

}
