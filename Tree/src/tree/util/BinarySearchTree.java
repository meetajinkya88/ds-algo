package tree.util;


public class BinarySearchTree
{

	private int noOfNodes;
	private int minRange;
	private int maxRange;

	public BinarySearchTree()
	{

	}

	public BinarySearchTree(int noOfNodes, int minRange, int maxRange)
	{
		setMaxRange(maxRange);
		setMinRange(minRange);
		setNoOfNodes(noOfNodes);
	}

	public TreeNode createBinarySearchTree()
	{

		TreeNode root = null;

		RandomTreeCreation randomTreeCreation = new RandomTreeCreation(noOfNodes, minRange, maxRange);

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

			// System.out.println("Tree Node Data is : " + treeNode.getData());

			attachNode(root, treeNode);

		}
		return root;
	}

	private static void attachNode(TreeNode root, TreeNode treeNode)
	{

		// System.out.println("TieNode value : " + tieNode);
		TreeNode current = root;
		TreeNode parent = null;

		while (current != null)
		{
			parent = current;

			if (treeNode.getData() < current.getData())
				current = current.getLeft();
			else
				current = current.getRt();
		}
		if (treeNode.getData() < parent.getData())
		{
			System.out.println("Attaching node " + treeNode.getData() + " On the left of " + parent.getData());

			parent.setLeft(treeNode);
		}
		else
		{
			System.out.println("Attaching node " + treeNode.getData() + " On the rt of " + parent.getData());

			parent.setRt(treeNode);
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
