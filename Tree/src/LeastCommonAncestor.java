import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tree.util.TreeNode;
import tree.util.TreeUtil;

/**https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 
 *   Least Common Ancestor(LCA) in a tree is defined as the first node that comes common
for both the given nodes while traveling towards the root. Write an efficient function
“TreeNode FindLca(TreeNode t, TreeNode p, TreeNode q)” to find the least common
ancestor of nodes p and q in a binary tree t. You are not allowed to modify the structure
of tree node. What are the time and space complexities of your solution? Assume that p
and q points to valid nodes in a given binary tree.

Input:     3
          / \
         4   7
        / \ / \
        5 1 6 8 
           /
          9

      p = ADDR(9) , q = ADDR(8) 

      output: ADDR(7)


 * @author ajinkyab
 *
 */
public class LeastCommonAncestor
{

	static List<Integer> nodePath = new ArrayList<Integer>();
    static boolean v1 = false, v2 = false; 
	public static void main(String[] args)
	{
		TreeNode root = TreeUtil.createTree();

		TreeUtil.printInorderTree(root);

		while(true)
		{
			Scanner scan = new Scanner(System.in);
		
			System.out.println("Enter node 1:");
			int	n1 = scan.nextInt();

			System.out.println("Enter node 2:");
			int n2 = scan.nextInt();

			// method 1
			LCA(root,n1,n2);
			nodePath.clear();

			//method 2
			findLCA(root,n1,n2);
			

			// method 3 
//			// Create an empty hash table.
//			Insert n1 and all of its ancestors in hash table.
//			Check if n2 or any of its ancestors exist in hash table, if yes return the first existing ancestor.

		//	scan.close();

		}

	}

	private static void LCA(TreeNode root, int n1, int n2)
	{
		List<Integer> path1 =new ArrayList<Integer>();
		List<Integer> path2 =new ArrayList<Integer>();

		getPath(root,n1,new ArrayList<Integer>());
		System.out.println("Path1: " + nodePath.toString());
		path1.addAll(nodePath);
		nodePath.clear();


		getPath(root,n2,new ArrayList<Integer>());
		System.out.println("Path2: " + nodePath.toString());
		path2.addAll(nodePath);
		nodePath.clear();

		int lca = getLCA(path1,path2);

		if(lca == -1)
		{
			System.out.println("No LCA preent between " + n1 + " and " + n2);
			return;
		}
		else
			System.out.println("LCA between " + n1 + " and " + n2 + " is " + lca);

	}

	private static int getLCA(List<Integer> path1, List<Integer> path2)
	{
		if(path1.size() <=0 || path2.size() <= 0)
			return -1;
		boolean found = false;
		int i = 0;
		for(; i < path1.size() && i < path2.size() ; i++)
		{
			if (!path1.get(i).equals(path2.get(i)))
			{
				found = true;
				break;
			}
		}
		return found ?  path1.get(i-1) : -1;
	}

	private static void getPath(TreeNode node, int n,List<Integer> path)
	{

		if(node == null)
			return;

		path.add(node.getData());

		if(node.getData() == n)
		{
			nodePath.addAll(path);
			return;
		}
		getPath(node.left,n,path);
		getPath(node.rt,n,path);

		if(path.size() > 0)
			path.remove(path.size() - 1);
	}

	 // This function returns pointer to LCA of two given 
    // values n1 and n2. 
    // v1 is set as true by this function if n1 is found 
    // v2 is set as true by this function if n2 is found 
	private static TreeNode findLCAUtil(TreeNode node, int n1, int n2) 
    { 
        // Base case 
        if (node == null) 
            return null; 
          
        //Store result in temp, in case of key match so that we can search for other key also. 
        TreeNode temp=null; 
  
        // If either n1 or n2 matches with root's key, report the presence 
        // by setting v1 or v2 as true and return root (Note that if a key 
        // is ancestor of other, then the ancestor key becomes LCA) 
        if (node.data == n1) 
        { 
            v1 = true; 
            temp = node; 
        } 
        if (node.data == n2) 
        { 
            v2 = true; 
            temp = node; 
        } 
  
        // Look for keys in left and right subtrees 
        TreeNode left_lca = findLCAUtil(node.left, n1, n2); 
        TreeNode right_lca = findLCAUtil(node.rt, n1, n2); 
  
        if (temp != null) 
            return temp; 
  
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca != null && right_lca != null) 
            return node; 
  
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
    } 
  
    // Finds lca of n1 and n2 under the subtree rooted with 'node' 
	private static void findLCA(TreeNode root,int n1, int n2) 
    { 
        // Initialize n1 and n2 as not visited 
        v1 = false; 
        v2 = false; 
  
        // Find lca of n1 and n2 using the technique discussed above 
        TreeNode lca = findLCAUtil(root, n1, n2); 
  
        // Return LCA only if both n1 and n2 are present in tree 
        if (v1 && v2) 
    		System.out.println("LCA between " + n1 + " and " + n2 + " is " + lca);

        System.out.println("Method2: No LCA present between " + n1 + " and " + n2);
    } 

}
