package BinaryTrees;

public class MaxOrMinInBinaryTree {

	Node root;
	public static class Node
	{
	    int key;
	    Node left, right;
	 
	    public Node(int key)
	    {
	        this.key = key;
	        left = right = null;
	    }
	}

	int findMax(Node root)
	{
		if(root == null){return 0;}
		int res = root.key;
		int lres = findMax(root.left);
		int rres = findMax(root.right);
		res = Math.max(res, Math.max(lres,rres));
		 /*if (lres > res)
		      res = lres;
		    if (rres > res)
		      res = rres;
		 */   return res;
	}
	
	int findMin(Node root)
	{
		if(root == null){return Integer.MAX_VALUE;}
		int res = root.key;
		int lres = findMin(root.left);
		int rres = findMin(root.right);
		res = Math.min(res, Math.min(lres,rres));
		return res;
		 /*if (lres < res && lres != 0)
		      res = lres;
		  if (rres < res && rres != 0)
		      res = rres;	
		    return res;*/
	}
		
	public static void main(String[] args) {
		
		MaxOrMinInBinaryTree tree = new MaxOrMinInBinaryTree();
		tree.root = new Node(19);
        tree.root.left = new Node(8);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(22);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(7);
        
       System.out.println("Max ::" + tree.findMax(tree.root));
        System.out.println("Min ::" + tree.findMin(tree.root));
	}

}
