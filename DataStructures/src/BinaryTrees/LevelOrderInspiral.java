package BinaryTrees;
/*
 *We can print spiral order traversal in O(n) time and O(n) extra space. The idea is to use two stacks. We can use one stack for printing from left 
 * to right and other stack for printing from right to left. In every iteration, we have nodes of one level in one of the stacks.
 * We print the nodes, and push nodes of next level in other stack. 
 * Time Complexcity : O(n) , Space Complexcity : O(n) 
 */
import java.util.Stack;

import BinaryTrees.ChildrenSumProperty.Node;
import LinkListProblems.LinkListInsertionsAndDeletions;

public class LevelOrderInspiral {

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

	void printSpiral(Node root){

		if (root == null) 
			return;   // NULL check
		// Create two stacks to store alternate levels
		Stack<Node> s1 = new Stack<Node>();// For levels to be printed from right to left
		Stack<Node> s2 = new Stack<Node>();// For levels to be printed from left to right
		// Push first level to first stack 's1'
		s1.push(root);
		// Keep printing while any of the stacks has some nodes
		while (!s1.empty() || !s2.empty()) 
		{
			// Print nodes of current level from s1 and push nodes of next level to s2
			while (!s1.empty()) 
			{
				Node temp = s1.pop();
				System.out.print(temp.key + " ");

				// Note that right is pushed before left
				if (temp.right != null) 
					s2.push(temp.right);

				if (temp.left != null) 
					s2.push(temp.left);
			}

			// Print nodes of current level from s2 and push nodes of next level to s1
			while (!s2.empty()) 
			{
				Node temp = s2.pop();
				System.out.print(temp.key + " ");
				// Note that is left is pushed before right
				if (temp.left != null)
					s1.push(temp.left);
				if (temp.right != null)
					s1.push(temp.right);
			}
		}	
	}

	public static void main(String[] args) {

		LevelOrderInspiral tree = new LevelOrderInspiral();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(6);
		tree.root.left.left.right = new Node(7);
		System.out.println("Spiral order traversal of Binary Tree is ");
		tree.printSpiral(tree.root);
	}

}