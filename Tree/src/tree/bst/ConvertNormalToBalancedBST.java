package tree.bst;

import java.util.ArrayList;
import java.util.List;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 * @author ajinkyab
 * 
 * Given a BST (Binary Search Tree) that may be unbalanced, convert it into a balanced BST that has minimum possible height.

Examples :

Input:
       30
      /
     20
    /
   10
Output:
     20
   /   \
 10     30


Input:
         4
        /
       3
      /
     2
    /
   1
Output:
      3            3           2
    /  \         /  \        /  \
   1    4   OR  2    4  OR  1    3   OR ..
    \          /                   \
     2        1                     4 

Input:
          4
        /   \
       3     5
      /       \
     2         6 
    /           \
   1             7
Output:
       4
    /    \
   2      6
 /  \    /  \
1    3  5    7 


Solution: 
 Simple Solution: is to traverse nodes in Inorder and one by one insert into a self-balancing BST like AVL tree. Time complexity of this solution is O(n Log n) and this solution doesn’t guarantee

An Efficient Solution: can construct balanced BST in O(n) time with minimum possible height. 
Below are steps.

    Traverse given BST in inorder and store result in an array. 
    This step takes O(n) time. Note that this array would be sorted as inorder traversal of BST
    always produces sorted sequence.
    Build a balanced BST from the above created sorted array using the recursive approach. 
    This step also takes O(n) time as we traverse every element exactly once
    and processing an element takes O(1) time.

 *
 */
public class ConvertNormalToBalancedBST
{
	static List<TreeNode> inorderList = new ArrayList<>();

	public static void main(String[] args)
	{

		TreeNode root = TreeUtil.createBinarySearchTree();

		TreeUtil.printInorderTree(root);
		
		inorderTraversal(root);
		
		if(inorderList.size() <=0)
			return;
		
		System.out.println("List size: " + inorderList.size());
		TreeNode newRoot = convertToBalancedBST(0,inorderList.size() -1);
		System.out.println("New Inorder Traversal Tree: \n");
		TreeUtil.printInorderTree(newRoot);
		
		System.out.println("New Preorder Traversal Tree: \n");
		TreeUtil.printTree(newRoot);


	}

	private static TreeNode convertToBalancedBST( int start, int end)
	{
		System.out.println("start: " + start + " end: " + end);
		if(start > end)
			return null;
		
		
		int mid = (start + end) /2;
		System.out.println("mid: " + mid);

		TreeNode node = inorderList.get(mid);
		node.left = convertToBalancedBST(0, mid -1);
		node.rt = convertToBalancedBST(mid +1 , end);

//		System.out.println("Node: " + node);
//		System.out.println("Node.left: " + node.left);
//		System.out.println("Node.rt: " + node.rt);

		return node;
	}


	private static void inorderTraversal(TreeNode root)
	{
		if (root == null)
			return;

		inorderTraversal(root.getLeft());
		inorderList.add(root);
		inorderTraversal(root.getRt());

		
	}

}
