//Two nodes of a BST are swapped, correct the BST

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data = data;
		this.left = this.right = null;
	}
}

class GFG {
	public static void storeInVector(Node root,
									ArrayList<Integer> vec)
	{
		if (root == null)
			return;
		storeInVector(root.left, vec);
		vec.add(root.data);
		storeInVector(root.right, vec);
	}
	public static void
	correctBSTUtil(Node root, ArrayList<Integer> vec,
				int[] index)
	{
		if (root == null)
			return;
		correctBSTUtil(root.left, vec, index);
		root.data = vec.get(index[0]);
		index[0]++;
		correctBSTUtil(root.right, vec, index);
	}

	public static void correctBST(Node root)
	{
		
		ArrayList<Integer> vec = new ArrayList<Integer>();
		storeInVector(root, vec);
		Collections.sort(vec);
		int[] index = { 0 };
		correctBSTUtil(root, vec, index);
	}

	public static void printInorder(Node root)
	{
		if (root == null)
			return;
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}

	public static void main(String[] args)
	{
		
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		
		System.out.println(
			"Inorder Traversal of the original tree");
		printInorder(root);

		correctBST(root);

		
		System.out.println(
			"\nInorder Traversal of the fixed tree");
		printInorder(root);
	}
}
