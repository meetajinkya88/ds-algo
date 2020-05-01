package tree.bst;

import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * https://www.youtube.com/watch?v=gcULXE7ViZw&list=PL2_aWCzGMAwI3W_JlcBbtYTwiQSsOTa6P&index=36
 * @author ajinkyab
 *
 */
public class DeleteNodeInBST
{

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createBinarySearchTree();

		TreeUtil.printInorderTree(root);
		Scanner scan = null;
		while(true)
		{
			System.out.println("Enter Tree Node to delete:");
			scan = new Scanner(System.in);
			int nodeData = scan.nextInt();
			root = deleteBST(root,nodeData);
			TreeUtil.printInorderTree(root);
			
			System.out.println("Enter Tree -1 to exit and 0 to continue:");
			if(scan.nextInt()== -1)
				break;


		}
		scan.close();

	}

	private static TreeNode deleteBST(TreeNode node, int nodeData)
	{
		if(node == null)
			return null;
		
		if(nodeData < node.data)
			node.left = deleteBST(node.left,nodeData);
		else if(nodeData > node.data)
			node.rt = deleteBST(node.rt, nodeData);
		else
		{
			if(node.left ==null && node.rt ==null)
				node = null;
			else if(node.left == null)
				node = node.rt;
			else if(node.rt == null)
				node = node.left;
			
			else
			{
				TreeNode successorNode = getMin(node.rt);
				node.data = successorNode.data;
				node.rt = deleteBST(node.rt, successorNode.data);
			}
		}
		
		return node;
		
	}

	private static TreeNode getMin(TreeNode node)
	{
		if(node== null)
		return null;
		
		if(node.left == null)
			return node;
		
		return getMin(node.left);
	}

}
