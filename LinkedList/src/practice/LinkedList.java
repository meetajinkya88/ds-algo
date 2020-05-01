package practice;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class LinkedList<T> implements List<T>
{

	private ListNode<T> head,last;
	private int size;


	public LinkedList()
	{
		head = new ListNode<T>();
		last = head;

	}

	@Override
	public boolean add(T e) 
	{
		ListNode<T> temp = new ListNode<T>(e);
		last.next = temp;
		last = temp;
		last.next = null;
		return true;
	}
	@Override
	public boolean contains(Object o)
	{
		for(ListNode<T> current = head.next ; current != null; current = current.next)
		{
			if(current.data.equals(o))
				return true;
		}
		return false;
	}
	@Override
	public boolean remove(Object o)
	{
		ListNode<T> prev = null;
		for(ListNode<T> current = head.next ; current != null; current = current.next)
		{
			if(current.data.equals(o))
			{
				if(prev == null)
				{
					head.next = current.next;
					return true;      
				}
				prev.next = current.next;
				return true;
			}
			prev  = current;

		}
		return false;

	}
	public void printAllNodes()
	{
		int i = 0;
		for(ListNode<T> current = head.next ; current!= null ; current = current.next)
		{
			
			System.out.print(current.data);
			System.out.print("--->");

			i++;
		}
		System.out.print("null\n");
	}
	public void printAllNodesRecursive()
	{
		printAllNodesRecursive(head.next);
	}

	private void printAllNodesRecursive(ListNode<T> node) 
	{
		if(node == null)
		{
			System.out.print("null\n");
			return;
		}
		System.out.print(node.data);
		System.out.print("--->");
		printAllNodesRecursive(node.next);	
	}

	public void printHeadNode()
	{
		if(head != null)
			System.out.println("Head: " + head.next.toString());
		else
			System.out.println("Head Node is null");
	}
	public void printLastNodel()
	{
		if(last != null)
			System.out.println("Last: " + last.toString());
		else
			System.out.println("Last Node is null");
	}

	@Override
	public int size() 
	{
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		last = null;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}


	public ListNode<T> head()
	{
		return this.head.next;
	}
	public void setHead(ListNode<T> node )
	{
		this.head.next  = node;
	}
}
