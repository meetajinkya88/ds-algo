package practice;


public class ListNode<T> 
{

	public T data ; 
	public ListNode<T> next; 
	
	public ListNode()
	{
		
	}
	public ListNode(T data)
	{
		this.data = data;
	}
	@Override
	public String toString() {
		return "ListNode [data=" + data + ", next=" + next + "]";
	}
	
}
