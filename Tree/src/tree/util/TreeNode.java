package tree.util;

import java.util.LinkedList;


public class TreeNode extends LinkedList<Integer>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7280404344211097452L;
	public Integer data ; 
	public TreeNode left;
	public TreeNode rt;

	
	public TreeNode()
	{
		
	}
	public TreeNode(Integer data)
	{
		this.data = data;
	}
	public Integer getData()
	{
		return data;
	}
	public void setData(Integer data)
	{
		this.data = data;
	}
	public TreeNode getLeft()
	{
		return left;
	}
	public TreeNode setLeft(TreeNode left)
	{
		this.left = left;
		return this.left;

	}
	public TreeNode getRt()
	{
		return rt;
	}
	public TreeNode setRt(TreeNode rt)
	{
		this.rt = rt;
		return this.rt;
	}
	
	
	
}