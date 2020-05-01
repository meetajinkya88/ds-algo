package tree.bst;

import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

public class InorderSuccessor
{

	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createBinarySearchTree();

		TreeUtil.printInorderTree(root);
		Scanner scan = null;
		while(true)
		{
			System.out.println("\n Enter Tree Node in order to find the successor:");
			scan = new Scanner(System.in);
			int nodeData = scan.nextInt();

			// method 1
			inOrderSuccessor(root, nodeData , 0);

			// method 2
			System.out.println("Method2: Inorder successor for node " + nodeData + " is :" + 	inOrderSuccessor(root,nodeData));

			//	System.out.println("Enter Tree -1 to exit and 0 to continue:");
			//	if(scan.nextInt()== -1)
			//		break;


		}
		//scan.close();

	}

	private static int inOrderSuccessor(TreeNode root, int nodeData)
	{
		if(root == null)
			return 0;

		TreeNode currNode = findNode(root,nodeData);

		if(currNode == null)
		{
			System.out.println("Curr node is null");
			return 0;
		}
		// case 1: where node has rt subtree. We need to find the min from the right subtree
		if(currNode.rt != null)
		{
			TreeNode successor = getMin(currNode.rt);
			return successor.data;
		}
		// Case 2: node does not have right subtree then we need to find the deepest ancestor

		TreeNode successor = null;
		TreeNode ancestor = root;

		while(ancestor != currNode)
		{
			if(currNode.data < ancestor.data)
			{
				successor = ancestor;
				ancestor = ancestor.left;
			}
			else
				ancestor = ancestor.rt;
		}
		
		if(successor != null)
			return successor.data;
		return 0;


	}

	private static TreeNode findNode(TreeNode node,int nodeData )
	{
		if(node == null)
			return null;
		TreeNode currNode = null;
		
		if(nodeData == node.data)
			return node;
		
		if(nodeData < node.data)
			currNode =	findNode(node.left,nodeData);
		
		if(currNode != null)
			return currNode;
		
		if(nodeData > node.data)
		currNode= findNode(node.rt, nodeData);
		
		return currNode;
	}

	/* Method 1
	 * this method will simply flag the "found" varibale to 1 if the concerned node found. 
	 * then it flags to 2 if the successor found and prints the successor.
	 *subsequently, it will return immediately if found variable value set as 2.
	 *
	 */
	private static int inOrderSuccessor(TreeNode node, int nodeData, int found)
	{
		if(node == null)
			return found;

		if(found == 2)
			return found;

		found = inOrderSuccessor(node.left, nodeData, found);
		if(found == 1)
		{
			System.out.println("Inorder successor for node " + nodeData + " is :" + node.data);
			found = 2;

			return found;
		}

		if(found ==0 && node.data == nodeData)
			found =1;

		found = inOrderSuccessor(node.rt, nodeData, found);

		return found;
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
