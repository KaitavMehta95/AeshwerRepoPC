package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

import BinaryTrees.LevelOrderLineByLine.Node;
/*
 *  We can use level order traversal to find height without recursion. The idea is to traverse level by level. Whenever move down to a level, 
 *  increment height by 1 (height is initialized as 0). Count number of nodes at each level, stop traversing when count of nodes at next level is 0
 */
public class HeightOfBinaryTreeIterative {
	Node root;
	static class Node
	{
		Node left;
		Node right;
		int key;
		Node(int key)
		{
			this.key =key;
			left= right = null;
		}
	}
	
	int heightOfTree()
	{
        // Base Case
        if (root == null)
            return 0;
        
        // Create an empty queue for level order traversal
        Queue<Node> q = new LinkedList<Node>();
        // Enqueue Root and initialize height
        q.add(root);
        int height = 0;
        
        while (true) 
        {
            // nodeCount (queue size) indicates number of nodes
            // at current level.
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
  
            // Dequeue all nodes of current level and Enqueue all
            // nodes of next level
            while (nodeCount > 0) 
            { // level order code
                Node newnode = q.poll();
                if (newnode.left != null)
                    q.add(newnode.left);
                if (newnode.right != null)
                    q.add(newnode.right);
                nodeCount--;
            }
        }
	}
	
	public static void main(String[] args) {

		HeightOfBinaryTreeIterative tree = new HeightOfBinaryTreeIterative();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Height of tree is :: "+ tree.heightOfTree());
	}

}
