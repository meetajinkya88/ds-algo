package tree.util;

import java.util.LinkedList;


public class ThreadedTreeNode extends LinkedList<Integer>
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7280404344211097452L;
	public Integer data ; 
	public ThreadedTreeNode left;
	public ThreadedTreeNode rt;
	public boolean rightThread;
	public boolean leftThread;   
	
	public ThreadedTreeNode()
	{
		
	}
	public ThreadedTreeNode(Integer data)
	{
		this.data = data;
	}
	public ThreadedTreeNode(Integer data,ThreadedTreeNode left,ThreadedTreeNode rt , boolean rightThread, boolean leftThread)
	{
		this.data = data;
		this.left = left;
		this.rt = rt;
		this.rightThread = rightThread;
		this.leftThread = leftThread;
	}
	public Integer getData()
	{
		return data;
	}
	public void setData(Integer data)
	{
		this.data = data;
	}
	public ThreadedTreeNode getLeft()
	{
		return left;
	}
	public void setLeft(ThreadedTreeNode left)
	{
		this.left = left;
	}
	public ThreadedTreeNode getRt()
	{
		return rt;
	}
	public void setRt(ThreadedTreeNode rt)
	{
		this.rt = rt;
	}
	public boolean isRightThread()
	{
		return rightThread;
	}
	public void setRightThread(boolean rightThread)
	{
		this.rightThread = rightThread;
	}
	public boolean isLeftThread()
	{
		return leftThread;
	}
	public void setLeftThread(boolean leftThread)
	{
		this.leftThread = leftThread;
	}
	
	
	
}
