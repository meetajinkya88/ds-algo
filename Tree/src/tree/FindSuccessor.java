package tree;

import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * @author ajinkyab
 *  // For a given node of a tree, find the predecessor node
 */
public class FindSuccessor
{

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();
		TreeUtil.printInorderTree(root);
		printSuccessor(root);

		}

		private static void printSuccessor(TreeNode root)
		{
			Scanner scan = new Scanner(System.in);
			
			int k = 0;
			while(true)
			{
				System.out.println("\n \n Enter value of K:");
				k = scan.nextInt();
				
				if(k == 0)
					break;
				
				
				
				printSuccessorNode(root,false,k);

			}
			
			scan.close();
			
		}

		private static void printSuccessorNode(TreeNode node, boolean nodeFound,int k)
		{
			if(node == null)
				return;
			this is not fully correct
			printSuccessorNode(node.getLeft(),nodeFound,k);
			if(nodeFound)
			{
				System.out.println(node.getData());
				return;
			}
			if(k == node.getData())
				return;
				
		    printSuccessorNode(node.getRt(),nodeFound,k);
		}

}
