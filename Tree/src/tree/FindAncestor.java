package tree;

import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * 
 * @author ajinkyab
 *https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 */
public class FindAncestor
{
	protected static StringBuffer buffer = new StringBuffer();

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
	
		printAllAncestor(root);

	}

	private static void printAllAncestor(TreeNode root)
	{
		Scanner scan = new Scanner(System.in);
		
		int k = 0;
		while(true)
		{
			System.out.println("\n \n Enter value of K:");
			k = scan.nextInt();
			
			if(k == 0)
				break;
			
			if(k ==root.getData())
			{
				System.out.println("No Ancestor available");
				break;
			}
			getAncestor(root,k);
			System.out.println("\n Nodes are : " + buffer.toString() );

			buffer.delete(0, buffer.length());		
		}
		
		scan.close();
		
	}

	private static boolean getAncestor(TreeNode node, int k)
	{
		if(node == null)
			return false;
		
	
		if(k == node.getData())
			return true;
	
		boolean nodeVisited = getAncestor(node.getLeft(), k);
		
		if(nodeVisited)
		{
			buffer.append(node.getData() + " " );
			return true;
		}
		
		nodeVisited = getAncestor(node.getRt(), k);
		
		if(nodeVisited)
		{
			buffer.append(node.getData() + " " );
			return true;
		}
		return false;
	}

}
