package tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * https://www.geeksforgeeks.org/print-left-view-binary-tree/
 * @author ajinkyab
 *
 *
Print Left View of a Binary Tree

Given a Binary Tree, print left view of it. Left view of a Binary Tree is set of nodes 
 visible when tree is visited from left side.
 
 Examples:

Input : 
                 1
               /   \
              2     3
             / \     \
            4   5     6             
Output : 1 2 4

Input :
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Output :1 2 4 5 6



 */
public class LeftViewBinaryTree
{

	static int maxLevel = 0;
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		
		System.out.println("Inorder Traversal of tree:");
		TreeUtil.printInorderTree(root);
		TreeNode curr  = root;
		
		System.out.println("\n Left View Binary Tree Node Using Recursion :");

		lvbt(curr,1);
		
		System.out.println("\n Left View Binary Tree Node Using Queue :");
		lvbt(curr);
	}
	/*
	 *  Solution1: We can keep track of level of a node by passing a parameter to all recursive calls.
   The idea is to keep track of maximum level also. Whenever we see a node whose level is more 
    than maximum level so far, we print the node because this is the first node in its level 
	 */
	private static void lvbt(TreeNode curr, int currentLevel)
	{
		if(curr == null) return;
		
		if(currentLevel > maxLevel)
		{
			maxLevel = currentLevel;
			System.out.print(" " + curr.getData());
		}
		lvbt(curr.getLeft(),currentLevel + 1);
		lvbt(curr.getRt(),currentLevel + 1);
	}
	
	/*
	 * Solution2: The left view contains all nodes that are first nodes in their levels.
	 *  A simple solution is to do level order traversal and print the first node in every level.
	 */
	private static void lvbt(TreeNode curr)
	{
		if(curr == null) return;
		
		Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
		queue.add(new TreeNode(-1));
		queue.add(curr);
		
		while(!queue.isEmpty())
		{
			if(queue.peek()!= null)
			{
				if(queue.peek().getData() == -1)
				{
					queue.poll();
					if(queue.peek() != null)
					{
						TreeNode node = queue.poll();
						System.out.print(" " + node.getData());
						
						queue.add(new TreeNode(-1));

						if(node.getLeft() != null)
							queue.add(node.getLeft());
						if(node.getRt() != null)
							queue.add(node.getRt());
						

					}
				}
				else
				{
					TreeNode node = queue.poll();
					
					if(node.getLeft() != null)
						queue.add(node.getLeft());
					if(node.getRt() != null)
						queue.add(node.getRt());
					
				}
			}
		}
	}
}
