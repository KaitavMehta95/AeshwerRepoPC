package BinaryTrees;


public class CountLeafNodes {
	Node root;
	static class Node
	{
		Node left;
		Node right;
		int key;
		Node(int key)
		{
			left = right= null;
			this.key = key;
		}
	}

	int CountLeaf(Node root){

		if(root == null){return 0;}
		
		if(root.left == null && root.right== null){return 1;}
		
		else
		return CountLeaf(root.left)+ CountLeaf(root.right);
	}
	
	public static void main(String[] args) {

		CountLeafNodes tree = new CountLeafNodes();
		//first tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println("The Number of leafs are :: " + tree.CountLeaf(tree.root));
        
        
	}

}
