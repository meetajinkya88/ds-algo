import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**
 * https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
 * @author ajinkyab
 * 
 *  A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.

Examples:

Input : k = 5  
        Root of below binary tree:
           1
        /     \
      3        -1
    /   \     /   \
   2     1   4     5                        
        /   / \     \                    
       1   1   2     6    
                       
Output :
3 2 
3 1 1 
1 3 1 
4 1 
1 -1 4 1 
-1 4 2 
5 
1 -1 5 

 Solution: The basic idea to solve the problem is to do a preorder traversal of the given tree. 
  We also need a container (vector) to keep track of the path that led to that node. 
  At each node we check if there are any path that sums to k, if any we print the path and proceed recursively to print each path.
 */
public class PrintAllKSumPath
{
    static FileWriter fw= null;   
	public static void main(String[] args) throws IOException
	{

		TreeNode root = new TreeNode(7);
		root.setRt(new TreeNode(2)).setRt(new TreeNode(9));
		root.getRt().setLeft(new TreeNode(3)).setRt(new TreeNode(-3));
		root.getRt().getLeft().setLeft(new TreeNode(4));
		root.setLeft(new TreeNode (-1)).setRt(new TreeNode(-5)).setRt(new TreeNode(4)).setLeft(new TreeNode(5));
		TreeUtil.printInorderTree(root);
		
		fw= new FileWriter("testout.txt"); 
		
		Scanner scan = null;
		int k = 0;
		while(k != -999)
		{
			System.out.println("\n Enter k (-999 in case of exit): ");
			scan = new Scanner(System.in);
			k = scan.nextInt();
			System.out.println("\n Selected K: " + k + " \n");
			 fw.write("\n Selected K: " + k + "\n");    
			List<Integer> path = new ArrayList<Integer>();
			printAllKSumPaths(root,path,k); 
		}
	}

	private static void printAllKSumPaths(TreeNode node, List<Integer> path, int k) throws IOException
	{
		if(node == null)
			return;
		
		path.add(node.data);
		printAllKSumPaths(node.left, path, k);
		printAllKSumPaths(node.rt, path, k);
		
	//	System.out.println("\n Path list:" + path.toString());
	//	 fw.write("\n Node to visit: " + node.getData());    

	//	 fw.write("\n Path list:" + path.toString());    

		printAllKSumPaths(path,k);
		
		fw.flush();
	    path.remove(path.size() - 1);  
	}

	private static void printAllKSumPaths(List<Integer> path, int k) throws IOException
	{
		 fw.write("\n");    
		int sum = 0;
		for(int i = path.size() -1 ; i >=0 ; i--)
		{
			sum += path.get(i);

			if(k == sum)
				printPath(path,i);
		}
	}

	private static void printPath(List<Integer> path, int i) throws IOException
	{
		fw.write("\n Path is: ");;
		System.out.print("\n Path is :" );

		while(i <= path.size() - 1)
		{
			 fw.write(" " + path.get(i));    
			System.out.print(" " + path.get(i));
			
			i++;
		}
	}

}
