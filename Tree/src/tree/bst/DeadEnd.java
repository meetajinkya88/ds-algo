package tree.bst;

/**
 * https://www.geeksforgeeks.org/simple-recursive-solution-check-whether-bst-contains-dead-end/
 * @author ajinkyab
 *Given a Binary Search Tree that contains positive integer values greater than 0. 
 *The task is to check whether the BST contains a dead end or not. 
 *Here Dead End means, we are not able to insert any integer element after that node.

Examples:

Input :        8
             /   \
           5      9
         /   \
        2     7
       /
      1
Output : Yes
Explanation : Node "1" is the dead End because
         after that we cant insert any element.

Input :       8
            /   \
           7     10
         /      /   \
        2      9     13

Output :Yes
Explanation : We can't insert any element at
              node 9.

Solution: First of all, it is given that it is a BST and nodes are greater than zero, root node can be 
in the range [1, ∞] and if root val is say, val, then left sub-tree can have the value in the range [1, val-1] 
and right sub-tree the value in range [val+1, ∞].
we need to traverse recursively and when the the min and max value of range coincided it means that we 
cannot add any node further in the tree.Hence we encounter a dead end.
 */
public class DeadEnd
{

	// Class containing left and right 
    // child of current node and key value 
    class Node { 
        int data; 
        Node left, right; 
  
        public Node(int item) { 
            data = item; 
            left = right = null; 
        } 
    } 
  
    // Root of BST 
    Node root; 
  
    // Constructor 
    DeadEnd() { 
        root = null; 
    } 
  
    // This method mainly calls insertRec() 
    void insert(int data) { 
    root = insertRec(root, data); 
    } 
  
    // A recursive function 
    // to insert a new key in BST 
    Node insertRec(Node root, int data) { 
  
        // If the tree is empty, 
        // return a new node 
        if (root == null) { 
            root = new Node(data); 
            return root; 
        } 
  
        /* Otherwise, recur down the tree */
        if (data < root.data) 
            root.left = insertRec(root.left, data); 
        else if (data > root.data) 
            root.right = insertRec(root.right, data); 
  
        /* return the (unchanged) node pointer */
        return root; 
    } 
  
// Returns true if tree with given root contains 
// dead end or not. min and max indicate range 
// of allowed values for current node. Initially 
// these values are full range. 
boolean deadEnd(Node root, int min, int max) 
{ 
    // if the root is null or the recursion moves 
    // after leaf node it will return false 
    // i.e no dead end. 
    if (root==null) 
        return false; 
  
    // if this occurs means dead end is present. 
    if (min == max) 
        return true; 
  
    // heart of the recursion lies here. 
    return deadEnd(root.left, min, root.data - 1)|| 
                deadEnd(root.right, root.data + 1, max); 
} 
  
  
    // Driver Program 
    public static void main(String[] args) { 
    	DeadEnd tree = new DeadEnd(); 
  
        /*       8 
               /   \ 
              5    11 
             /  \ 
            2    7 
             \ 
              3 
               \ 
                4 */
        tree.insert(8); 
        tree.insert(5); 
        tree.insert(2); 
        tree.insert(3); 
        tree.insert(7); 
        tree.insert(11); 
        tree.insert(4); 
  
        if (tree.deadEnd(tree.root ,1 , 
                Integer.MAX_VALUE) == true) 
  
        System.out.println("Yes "); 
        else
        System.out.println("No " ); 
    } 
}
