package BinaryTrees;


public class BinaryTreeBasic {

	Node root; 	// Root of Binary Tree
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

	public static void main(String[] args) {

		BinaryTreeBasic tree = new BinaryTreeBasic();
		tree.root= new Node(10);

		Node new_node = new Node(3);
		tree.root.left = new_node;

		Node new_node2 = new Node(20);
		tree.root.right = new_node2;

		Node new_node3 = new Node(70);
		new_node2.left = new_node3;


	}

}
