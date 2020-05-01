package tree.util;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import tree.node.TreeNode;

/**
 * 
 * @author ajinkyab
 * 
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 *  solution 2
 */  
public class MaximumWidthOfBT
{
	protected static  Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		
		System.out.println("Maximum Width is: " + maxWidth(root));
	}

	private static int maxWidth(TreeNode root)
	{
		int width = 0;
		
		if(root == null)
			return 0;
		
		TreeNode node = root;
		queue.add(node);
		while(!queue.isEmpty())
		{
			int count = queue.size();
			
			if(count > width)
				width = count;
			
			while(count > 0)
			{
				TreeNode node1 = queue.remove();
				
				if(node1.getLeft() != null)
					queue.add(node1.getLeft());
				if(node1.getRt() != null)
					queue.add(node1.getRt());
				
				count --;
			}
		}
		return width;
	}

	private static TreeNode getMarkerNode()
	{
		TreeNode node = new TreeNode(-9999);
		return node;
	}

}
