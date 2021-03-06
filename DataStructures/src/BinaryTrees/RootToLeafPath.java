package BinaryTrees;
/*
 * Given a binary tree, print out all of its root-to-leaf paths one per line. Note here that in each recursive call the array is filled 
 * till a different index . HARD LEVEL PROGRAM 
 */
public class RootToLeafPath {
	
	
	Node root;
	public static class Node
	{
		int key;
		Node left;
		Node right;
		Node(int key){
			this.key = key;
			left = right = null; 
		}
	}
	
	 /* Recursive helper function -- given a node, and an array containing
    the path from the root node up to but not including this node,print out all the root-leaf paths. */
	void rootToLeafPaths(Node root,int path[],int pathLen)
	{
		if(root == null ){return;}
		
		 /* append this node to the path array */
        path[pathLen] = root.key;
        pathLen++;
  
        /* it's a leaf, so print the path that led to here */
        if (root.left == null && root.right == null)
            printArray(path, pathLen);
        else
            { 
            /* otherwise try both subtrees */
        	rootToLeafPaths(root.left, path, pathLen);
        	rootToLeafPaths(root.right, path, pathLen);
        }
	}
	
	 /* Given a binary tree, print out all of its root-to-leaf
    paths, one per line. Uses a recursive helper to do the work.*/
	void printPaths(Node root) 
	{
		int path[] = new int[1000];
		rootToLeafPaths(root, path, 0);
	}
	
	/* Utility that prints out an array on a line */
    void printArray(int path[], int len) 
    {
        int i;
        for (i = 0; i < len; i++)
            {System.out.print(path[i] + " ");}
        System.out.println("");
    }
  
	
	public static void main(String[] args) {
		
		RootToLeafPath tree = new RootToLeafPath();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        /* Print all root-to-leaf paths of the input tree */
        tree.printPaths(tree.root);
	}
}
