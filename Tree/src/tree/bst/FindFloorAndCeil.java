package tree.bst;

import java.util.Scanner;

import tree.node.TreeNode;
import tree.util.BinarySearchTree;


/** 
 *   Find an efficient algorithm to compute the floor and ceil of given element in a BST.
Floor(x) refers to maximum element that is smaller than x. Ceil(x) refers to minimum
element that is higher than x.
      Input:   13
			  /  \
              9  16
             / \ / \
            5 10 14 18
Output:
        Floor(17): 16 Ceil(17): 18
        Floor(10): 10 Ceil(10): 10

 * @author ajinkyab
 *
 */
public class FindFloorAndCeil
{

	public static void main(String[] args)
	{
		TreeNode root = createBinarySearchTree();

		printTree(root);

		Scanner scan = null;
		int n;
		do
		{
			scan = new Scanner(System.in);
			System.out.println("Enter the no.which you want to find floor and ceil value : ");
			n = scan.nextInt();

			System.out.println("Floor Value for " + n + " in tree is : " + findFloor(root, n));
			System.out.println("Ceil Value for " + n + " in tree is : " + findCeil(root, n));

			
		} while (n > 0);


	}

	private static int findCeil(TreeNode root, int n)
	{
		int ceil = 0; 
		
		if(root == null)
			return 0;
		
		if(root.getData() == n)
			return root.getData();
		
	
		ceil = findCeil(root.getLeft(), n);
		
		if(ceil > 0 )
			return ceil ;
		
		if(root.getData() > n)
			return root.getData();
		
		ceil = findCeil(root.getRt(), n);
		return ceil;
	}

	private static int findFloor(TreeNode root, int n)
	{
		int floor = 0;
		int floor2 = 0;
		
		if(root == null)
			return 0;
		
		if(root.getData() == n)
			return root.getData();
	
		
		floor = findFloor(root.getLeft(), n);

		if(root.getData() < n && root.getData() > floor)
			floor = root.getData();
	
		floor2 = findFloor(root.getRt(), n);

	
		
	
		if(floor> floor2)
			return floor;
		else
			return floor2;
		
	
		
			
//	/	return floor;
	}

	private static TreeNode createBinarySearchTree()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no. of Nodes : ");
		int noOfNodes = scan.nextInt();

		System.out.println("Enter Min Range : ");
		int minRange = scan.nextInt();

		System.out.println("Enter Max. Range : ");
		int maxRange = scan.nextInt();
		return (TreeNode) new BinarySearchTree(noOfNodes, minRange, maxRange).createBinarySearchTree();

	}

	private static void printTree(TreeNode root)
	{
		if (root == null)
			return;

		System.out.println(root.getData());
		printTree(root.getLeft());
		printTree(root.getRt());

	}

}
