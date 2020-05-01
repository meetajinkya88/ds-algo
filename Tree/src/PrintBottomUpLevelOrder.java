import java.util.ArrayList;
import java.util.Scanner;

import tree.height.FindHeight;
import tree.util.BinaryTree;
import tree.util.TreeNode;



/**
 * Write an efficient function that takes a binary tree as input and displays the elements of
tree level by level, but from last level to first. What are the time and space complexities
of your solution?
Function prototype:
void bottomUpLevel(TreeNode t)
Input: 3
      / \
     4   7
    / \ / \
    5 1 6 8
Output: 5 1 6 8 4 7 3

https://www.geeksforgeeks.org/reverse-level-order-traversal/

 * @author ajinkyab
 *
 */
public class PrintBottomUpLevelOrder
{

	public static void main(String[] args)
	{
		TreeNode root = createTree();
	
		
		printTree(root);

		printBottomUpLevelOrderNonRecursive(root);
		printBottomUpLevelOrderRecursive(root);


	}

	 /**
	  * n method 1, we have a method printGivenLevel() which prints a given level number.
	  *   The only thing we need to change is, instead of calling printGivenLevel() from first level 
	  *    to last level, we call it from last level to first level.
	  * @param root
	  */
	private static void printBottomUpLevelOrderRecursive(TreeNode root)
	{
		int height = FindHeight.findHeightOfTreeWithoutRecusrion(root);
		
		System.out.println("\n \n Height of the binary tree: " + height);
		System.out.println("\n Printing Bottom Level Order Recursive as follows :\n\t" );

		for(int i = height ; i > 0 ; i--)
			printLevelOrderNodes(root,1,i);
	}

	private static void printLevelOrderNodes(TreeNode node, int actualHt, int expectedHt)
	{
		if(node == null) return;
		
		if(actualHt == expectedHt)
			System.out.print( node.getData() + " ");
		
		printLevelOrderNodes(node.getLeft(),actualHt + 1 , expectedHt);
		printLevelOrderNodes(node.getRt(),actualHt + 1 , expectedHt);

	}

	private static void printBottomUpLevelOrderNonRecursive(TreeNode root)
	{
		ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
		int i = 0;
		if(root == null)
			return;
		else
			treeList.add(root);
		
		System.out.println("\n Printing Bottom Level Order Non Recursive as follows :\n\t" );

		while(true)
		{
			if(i >= treeList.size())
				break;
	
			
			TreeNode node = treeList.get(i);
			if(node.getRt() != null)
			{
				treeList.add(node.getRt());
			
			}
			if(node.getLeft()!= null)
			{
				treeList.add(node.getLeft());
				
			}
			i++;
			
				
		}
		
		for(int j=treeList.size() - 1  ; j>=0 ; j--)
			System.out.print(treeList.get(j).getData() + " ");

		
	}

	private static TreeNode createTree()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Nodes : ");
		int noOfNodes = scan.nextInt();

		System.out.println("Enter Min Range : ");
		int minRange = scan.nextInt();

		System.out.println("Enter Max. Range : ");
		int maxRange = scan.nextInt();
		return (TreeNode) new BinaryTree(noOfNodes, minRange, maxRange).createBinaryTree();

	}

	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}
}
