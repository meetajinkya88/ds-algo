package tree;

import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * @author ajinkyab
 * https://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 */
public class PrintNodesAtDistanceK
{

	protected static StringBuffer buffer = new StringBuffer();
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		
		printNodesAtDistanceK(root);
	}

	private static void printNodesAtDistanceK(TreeNode root)
	{
		Scanner scan = new Scanner(System.in);
	
		int k = 0;
		while(true)
		{
			System.out.println("\n \n Enter value of K:");
			k = scan.nextInt();
			
			if(k == 0)
				break;
			
			printNodes(root,k);
			
			System.out.println("\n Nodes are : " + buffer.toString() );

			buffer.delete(0, buffer.length());		
		}
		
		scan.close();
		
	}

	private static void printNodes(TreeNode node, int k)
	{
		if(node == null)
			return;
		
		System.out.println("Node is : " + node.getData());
		System.out.println("K Value is : " + k);
		if(k == 0)
		{
			buffer.append(node.getData() + " ,");
			return;
		}	
		k --;
		printNodes(node.getLeft() , k);
		printNodes(node.getRt() , k);

		
	}

}
