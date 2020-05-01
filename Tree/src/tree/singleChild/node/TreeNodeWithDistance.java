package tree.singleChild.node;

import tree.util.TreeNode;

public class TreeNodeWithDistance extends TreeNode
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1834769919501863598L;
	private int distance;
	
	public TreeNodeWithDistance(TreeNode node , int distance)
	{
		this.setData(node.getData());
		this.setDistance(distance);
		this.setLeft(node.getLeft());
		this.setRt(node.getRt());
		
	}

	public int getDistance()
	{
		return distance;
	}

	public void setDistance(int distance)
	{
		this.distance = distance;
	}
	
	
}
