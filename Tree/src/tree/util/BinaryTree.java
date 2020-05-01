package tree.util;

import java.util.HashSet;
import java.util.Set;

public class BinaryTree
{

	private int noOfNodes;
	private int minRange;
	private int maxRange;
	
	
	public BinaryTree()
	{
		
	}
	public BinaryTree(int noOfNodes, int minRange, int maxRange)
	{
		setMaxRange(maxRange);
		setMinRange(minRange);
		setNoOfNodes(noOfNodes);
	}

	
	public  TreeNode createBinaryTree()
	{

		TreeNode root = null;


		RandomTreeCreation  randomTreeCreation = new RandomTreeCreation(noOfNodes, minRange, maxRange);
		RandomTreeCreation randomTieNode = new RandomTreeCreation(noOfNodes, 0, 10);

		for (int i = 0; i < noOfNodes; i++)
		{

			if (root == null)
			{
				root = new TreeNode();
				root.setData(randomTreeCreation.randomInteger());
				System.out.println("Root Data is : " + root.getData());
				continue;
			}

			TreeNode treeNode = new TreeNode();
			treeNode.setData(randomTreeCreation.randomInteger());
			
		//	System.out.println("Tree Node Data is : " + treeNode.getData());

			attachNode(root, randomTieNode, treeNode);

		}
		return root;
	}

	
	private static void attachNode(TreeNode root, RandomTreeCreation randomTieNode, TreeNode treeNode)
	{
		int tieNode = randomTieNode.randomInteger();
		
		//System.out.println("TieNode value : " + tieNode);

		if(root.getData() == treeNode.getData())
			return;
		
		if (tieNode < 5)
		{
			if(root.getLeft() == null)
			{
				root.setLeft(treeNode);
				System.out.println("Attaching node " + treeNode.getData() + " On the left of " + root.getData());
			}
			else
				attachNode(root.getLeft(), randomTieNode, treeNode);
		}
		else
		{
			if(root.getRt() == null)
			{
				root.setRt(treeNode);
				System.out.println("Attaching node " + treeNode.getData() + " On the right of " + root.getData());

			}
			else
				attachNode(root.getRt(), randomTieNode, treeNode);
	
		}

	}
	public int getNoOfNodes()
	{
		return noOfNodes;
	}

	public void setNoOfNodes(int noOfNodes)
	{
		this.noOfNodes = noOfNodes;
	}

	public int getMinRange()
	{
		return minRange;
	}

	public void setMinRange(int minRange)
	{
		this.minRange = minRange;
	}

	public int getMaxRange()
	{
		return maxRange;
	}

	public void setMaxRange(int maxRange)
	{
		this.maxRange = maxRange;
	}
}
