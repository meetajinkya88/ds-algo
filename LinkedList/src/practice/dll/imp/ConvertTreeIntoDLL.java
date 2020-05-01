package practice.dll.imp;

public class ConvertTreeIntoDLL
{
	static Node inorder;
	public class Node 
	{ 
		int val; 
		Node left,right; 

		public Node(int val) 
		{ 
			this.val = val; 
			left = right = null; 
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", left=" + left + ", right=" + right + "]";
		} 


	} 

	// A class to represent a tree 
	public class Tree 
	{ 
		Node root; 
		public Tree()
		{

		}
	}

	public static void main(String[] args) 
	{
		ConvertTreeIntoDLL dll = new ConvertTreeIntoDLL();
		Tree tree = dll.new Tree(); 
		tree.root = dll.new Node(10); 
		tree.root.left = dll.new Node(12); 
		tree.root.right = dll.new Node(15); 
		tree.root.left.left = dll.new Node(25); 
		tree.root.left.left.right = dll.new Node(17); 
		tree.root.left.left.right.left = dll.new Node(7); 

		tree.root.left.right = dll.new Node(30); 
		tree.root.right.left = dll.new Node(36); 

		// head refers to the head of the Link List 
		Node head = dll.treeTODLL(tree.root); 

		// Display the Circular LinkedList 
		dll.display(head); 

	}
	private Node treeTODLL(Node root) 
	{
		if(root != null)
		{
			Node head = getHead(root);
			System.out.println("New DLL head is: " + head);
			auxtreeToDLL(root);
			inorder.right= head;
			head.left = inorder;
			return head;
		}
		return null;
	}
	private void auxtreeToDLL(Node node) 
	{
		if(node == null)return;

		auxtreeToDLL(node.left);
		if(inorder == null)
			inorder = node;
		else
		{
			inorder.right = node;
			node.left = inorder;
			inorder = node;
		}
		auxtreeToDLL(node.right);
	}
	private  Node getHead(Node node) 
	{
		if(node.left == null)
			return node;

		return getHead(node.left);	

	}
	public  void display(Node head) 
	{ 
		if(head == null)
		{
			System.out.println("Tree is empty...");
			return;
		}
		System.out.println("Doubly Linked List is :"); 
		Node itr = head; 
		do
		{ 
			System.out.print(itr.val+ "-->" ); 
			itr = itr.right; 
		} 
		while (itr != head); 
		
		System.out.print(itr.val+ " " ); 
		itr = itr.right; 
		System.out.println(); 
	} 

}
