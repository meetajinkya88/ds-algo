
package tree;

import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * 
 * @author ajinkyab
 *  // For a given node of a tree, find the predecessor node
 */
public class FindPredecissor
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
				
				
				if(k ==root.getData())
				{
					System.out.println("No Predecissor available");
					break;
				}
				printFindPredecissorNode(root,k);

			}
			
			scan.close();
			
		}

		private static boolean printFindPredecissorNode(TreeNode node, int k)
		{
			if(node == null)
				return false;
			
			boolean nodeFound = printFindPredecissorNode(node.getLeft(), k);
			if(nodeFound)
			{
				System.out.println(node.getData());
				return false;
			}
			if(k == node.getData())
			{
				return true;			
			}
			printFindPredecissorNode(node.getRt(), k);
			return false;
		}

}
