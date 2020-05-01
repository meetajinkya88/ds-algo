package tree;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class PreOrderTraversalWithoutRecursion
{
	protected static List<TreeNode> stack = new ArrayList<TreeNode>();
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printTree(root);
		
		preorderTraversal(root);
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
	private static void preorderTraversal(TreeNode root)
	{
		TreeNode node = root;
		TreeNode popNode = null;
		boolean alreadyVisited = false;
		push(node);
		System.out.println("Node:" + node.getData());

		while(!isStackEmpty())
		{
			node = peek();
			
			if(node.getLeft() != null && !alreadyVisited)
			{
				System.out.println("Node:" + node.getLeft().getData());
				push(node.getLeft());
				alreadyVisited = false;

			}
			else
			{
				if(node.getRt() !=null)
				{
					popNode = pop();
					System.out.println("Node:" + node.getRt().getData());
					push(node.getRt());
					alreadyVisited = false;
				}
				else
				{
					alreadyVisited = true;
					pop();
				}
			}
			
		}
	}

}
