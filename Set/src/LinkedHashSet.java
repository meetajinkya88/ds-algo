import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;


public class LinkedHashSet implements Set
{

	int size;
	int input;
	int maxElements = 25;
	int totalbucekts = 5;
	Integer []totalbucketSize = new Integer[totalbucekts];
	int loadFactor = maxElements/totalbucekts;
	Hashtable <Integer,ListNode> hashTable = new Hashtable <Integer,ListNode>();
	ListNode head = new ListNode();
	ListNode last = head;
	

	public static void main(String[] args)
	{

		LinkedHashSet hashSet = new LinkedHashSet();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(5);
		hashSet.add(4);
		hashSet.add(3);
		hashSet.add(6);
		
		hashSet.display();


	}

	protected void display()
	{
		System.out.println("List order is : ");
		for(ListNode current = head.next; current !=null ; current = current.next)
		{
			System.out.println(current.data + "-->");
		}
		
		for(Entry<Integer,ListNode> entry: hashTable.entrySet())
		{
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue().getData());
		}
		
	}

	@Override
	public boolean add(Object e)
	{
		input = (Integer)e;
        if(size == loadFactor)
        	hashTable.remove(leastRecentlyUsed(e));
		//if(hashTable.get(hashCode()) == null)
		//{
		ListNode node = new ListNode();
		node.data = input;

		if(head.next ==null)
		{
			node.prev = head;
			head.next = node;
			last = node;
			
			hashTable.put(hashCode(), node); 
			return true;
		}
		else
		{
			for(ListNode current = head.next; current !=null ; current = current.next)
			{
				
			}
		}
		return false;
		
		/*else
		{
			for(ListNode current = head.next; current !=null ; current = current.next)
			{
				if(node.data < current.data)
				{						
					node.next = current;
					node.prev = current.prev;
					current.prev.next = node;
					current.prev = node;

					hashTable.put(hashCode(), node); 

					return true;
				}

			}
			last.next = node;
			node.prev = last;
			last= node;

			hashTable.put(hashCode(), node); 

			return true;
		}*/




	}


	private Object leastRecentlyUsed(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size()
	{
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		return size > 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() 
	{


	}


	public int hashCode()
	{
		return input%totalbucekts;

	}
	class ListNode
	{
		int data;
		ListNode next;
		ListNode prev;

		public int getData()
		{
			return data;
		}
		public void setData(int data)
		{
			this.data = data;
		}



	}
}
