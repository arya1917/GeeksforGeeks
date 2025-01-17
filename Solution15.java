class Node{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class Maximum {
	int max_no = Integer.MIN_VALUE;
}

class BinaryTree {
	Node root;
	Maximum max = new Maximum();
	Node target_leaf = null;
	boolean printPath(Node node, Node target_leaf)
	{
		if (node == null)
			return false;
		if (node == target_leaf || printPath(node.left, target_leaf)
			|| printPath(node.right, target_leaf)) {
			System.out.print(node.data + " ");
			return true;
		}

		return false;
	}
	void getTargetLeaf(Node node, Maximum max_sum_ref, int curr_sum)
	{
		if (node == null)
			return;

		curr_sum = curr_sum + node.data;

		if (node.left == null && node.right == null) {
			if (curr_sum > max_sum_ref.max_no) {
				max_sum_ref.max_no = curr_sum;
				target_leaf = node;
			}
		}

		getTargetLeaf(node.left, max_sum_ref, curr_sum);
		getTargetLeaf(node.right, max_sum_ref, curr_sum);
	}

	int maxSumPath()
	{
	
		if (root == null)
			return 0;
		getTargetLeaf(root, max, 0);

		printPath(root, target_leaf);
		return max.max_no; 
	}
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(7);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(-4);
		System.out.println("Following are the nodes "
						+ "on maximum sum path");
		int sum = tree.maxSumPath();
		System.out.println("");
		System.out.println("Sum of nodes is : " + sum);
	}
}