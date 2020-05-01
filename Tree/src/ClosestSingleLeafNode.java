import java.util.ArrayList;
import java.util.Scanner;

import tree.singleChild.node.TreeNodeWithDistance;
import tree.util.BinaryTree;
import tree.util.TreeNode;


/**
 * Given a Binary Tree and a node x in it, find distance of the closest leaf to x in Binary Tree. 
 * If given node itself is a leaf, then distance is 0.
 * 
 * Input: Root of below tree
       And x = pointer to node 13
          10
       /     \
     12       13
             /     
           14      
Output 1
Distance 1. Closest leaf is 14.

 * @author ajinkyab
 *
 */
public class ClosestSingleLeafNode
{
	
	public static void main(String []args)
	{
		
		TreeNode root = createTree();
		printTree(root);
		findClosestSingleLeafNode(root);
	}

	private static void findClosestSingleLeafNode(TreeNode root)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the start node");
		int nodeVal = in.nextInt();
		System.out.println("Choosen node is: " + nodeVal);
		
		TreeNode node = getSelectedNode(root,nodeVal);
		
		if(node == null)
		{
			System.out.println("Choosen Node not found");
			return;
		}
		
		auxfindClosestSingleLeafNode(node,0);
		
				
				
	}

	private static TreeNodeWithDistance  auxfindClosestSingleLeafNode(TreeNode node,int distance)
	{
	
		if(node != null && node.getLeft() == null && node.getRt() == null)
		{
			TreeNodeWithDistance distanceNode = new TreeNodeWithDistance(node, distance);
			System.out.println("Closest Leaf node is :" + node.getData());
			System.out.println("Closest Leaf node distance is :" + distance);

			return distanceNode;
		}
		
		TreeNodeWithDistance distanceNode = null;
		if(node != null && node.getLeft() != null )
			 distanceNode = auxfindClosestSingleLeafNode(node.getLeft(),++distance);
		
		if(distanceNode != null && node != null && node.getRt() != null )
			distanceNode = auxfindClosestSingleLeafNode(node.getRt(),++distance);
		
		return distanceNode;
		
		
		
	}

	private static TreeNode getSelectedNode(TreeNode root,int nodeVal)
	{
			
		if(root.getData() == nodeVal)
			return root;
		
		if(root != null && root.getLeft()!= null && root.getData() != nodeVal)
		root = getSelectedNode(root.getLeft(),nodeVal);
		
		if(root!=null && root.getRt() != null && root.getData() != nodeVal)
		root = getSelectedNode(root.getRt(),nodeVal);
		
		return root;

	}
	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

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
	

}
