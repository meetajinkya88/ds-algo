package tree;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class PostOrderTraversalWithoutRecursion
{
	protected static List<TreeNode> stack1 = new ArrayList<TreeNode>();
	protected static List<TreeNode> stack2 = new ArrayList<TreeNode>();

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printPostOrderTree(root);

		// not complete yet
		//postOrderTraversal(root);
		
		// using 2 stacks
//	/	postOrderTraversal2(root);

		postOrderItrOneStack(root);
		
	}

	
	 public static void postOrderItrOneStack(TreeNode node)
	 {
		 TreeNode current = node;
	        while(current != null || !isStackEmpty(stack1))
	        {
	            if(current != null)
	            {
	                push(current,stack1);
	                current = current.getLeft();
	            }
	            else
	            {
	            	TreeNode temp = peek(stack1).getRt();
	                if (temp == null) 
	                {
	                    temp = pop(stack1);
	                    System.out.print(temp.getData() + " ");
	                    while (!isStackEmpty(stack1) && temp == peek(stack1).getRt()) 
	                    {
	                        temp = pop(stack1);
	                        System.out.print(temp.getData() + " ");
	                    }
	                } else 
	                {
	                    current = temp;
	                }
	            }
	        }
	}
	private static void postOrderTraversal2(TreeNode root)
	{
		
		TreeNode node = root;
		push(node,stack1);

		while(!isStackEmpty(stack1))
		{
			node = pop(stack1);
			push(node,stack2);
			
			if(node.getLeft() != null)
				push(node.getLeft(),stack1);
			if(node.getRt() != null)
				push(node.getRt(),stack1);
			
			
		}
		
		System.out.print("PostOrder Traversal:"); 
		while(!isStackEmpty(stack2))
		{
			System.out.print(pop(stack2).getData() + " , ");
		}
	}

	protected static void push(TreeNode node,List<TreeNode> stack)
	{
		stack.add(node);
	}
	protected static TreeNode pop(List<TreeNode> stack)
	{
		if(stack != null && stack.size() > 0)
			return stack.remove(stack.size() -1);

		return null;
	}
	protected static boolean isStackEmpty(List<TreeNode> stack)
	{
		return stack.isEmpty();
	}

	protected static TreeNode peek(List<TreeNode> stack)
	{
		if(stack != null && stack.size() > 0)
			return stack.get(stack.size() -1);

		return null;
	}
	private static void postOrderTraversal(TreeNode root)
	{
		TreeNode node = root;
		TreeNode popNode = null;
		boolean alreadyVisited = false;
		push(node,stack1);

		System.out.println("Pushing:" + node.getData());

		int i = 0 ;
		while(!isStackEmpty(stack1))
		{
			if(i == 20)
				break;
			System.out.println("Node On top:" + peek(stack1).getData());

			node = peek(stack1);
			if(node.getLeft() != null && node.getLeft() != popNode)
			{
				push(node.getLeft(),stack1);
				System.out.println("Pushing Left:" + node.getLeft().getData());
				node = node.getLeft();
				continue;
			}
			
			if(node.getRt() != null && node.getRt() != popNode)
			{
				push(node.getRt(),stack1);
				System.out.println("Pushing Right:" + node.getRt().getData());
				node = node.getRt();
				continue;
			}
			
			popNode = pop(stack1);
			System.out.println("Popping Node: " + popNode.getData());
			
			i++;
		}

	}

}
