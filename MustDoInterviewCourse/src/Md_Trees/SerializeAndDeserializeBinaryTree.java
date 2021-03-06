package Md_Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class SerializeAndDeserializeBinaryTree {

	static class Tree {
		int data;
		Tree left, right;

		Tree(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Tree root = null;
			if (n == 1) {
				System.out.println(sc.nextInt());
				n--;
			}
			while (n-- > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (root == null) {
					root = new Tree(n1);
					switch (lr) {
					case 'L':
						root.left = new Tree(n2);
						break;
					case 'R':
						root.right = new Tree(n2);
						break;
					}
				} else {
					insert(n1, n2, lr, root);
				}
			}
			ArrayList<Integer> aa = new ArrayList<Integer>();
			SerializeAndDeserializeBinaryTree g = new SerializeAndDeserializeBinaryTree();
			String s = g.serialize(root, aa);
			Tree root1 = g.deSerialize(s);
			inorder(root1);
			System.out.println();
		}
	}

	public static void inorder(Tree root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void insert(int n1, int n2, char lr, Tree root) {
		if (root == null) {
			return;
		}
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new Tree(n2);
				break;
			case 'R':
				root.right = new Tree(n2);
				break;
			}
		}
		insert(n1, n2, lr, root.left);
		insert(n1, n2, lr, root.right);

	}

	public String serialize(Tree root, ArrayList<Integer> aa) {
		
		return null;
	}

	public Tree deSerialize(String data) {
		return null;
	}
}
