// Java code for the above approach 
import java.util.Stack; 


class Node { 
Node left, right; 
int key; 

Node(int key) 
{ 
	this.key = key; 
	left = right = null; 
} 
} 

class BinaryTree { 
 
static Node newNode(int key) 
{ 
	Node temp = new Node(key); 
	return temp; 
} 

 
static void findPath(Node root, int d, String str, 
					StringBuilder s) 
{ 
	if (root == null) { 
	return; 
	} 

	if (root.key == d) { 
	s.append(str); 
	return; 
	} 
	findPath(root.left, d, str + "l", s); 
	findPath(root.right, d, str + "r", s); 
} 

static Node findLCAUtil(Node root, int n1, int n2) 
{ 
	
	if (root == null) 
	return null; 

	if (root.key == n1) 
	return root; 
	if (root.key == n2) 
	return root; 
	
	Node left_lca = findLCAUtil(root.left, n1, n2); 
	Node right_lca = findLCAUtil(root.right, n1, n2); 
	if (left_lca != null && right_lca != null) { 
	return root; 
	} 
	return (left_lca != null) ? left_lca : right_lca; 
} 


static Node findLCA(Node root, int first, int second) 
{ 
	if (root == null) { 
	return null; 
	} 
	Node lca = findLCAUtil(root, first, second); 

	if (find(lca, first) && find(lca, second)) { 
	return lca; 
	} 
	return null; 
} 

static boolean find(Node root, int x) 
{ 
	if (root == null) { 
	return false; 
	} 
	if ((root.key == x) || find(root.left, x) 
		|| find(root.right, x)) { 
	return true; 
	} 
	return false; 
} 

static int numberOfTurns(Node root, int first, 
						int second) 
{ 
	
	if (root == null || (first == second)) { 
	return 0; 
	} 

	StringBuilder s1 = new StringBuilder(); 
	StringBuilder s2 = new StringBuilder(); 
	Node lca = findLCA(root, first, second); 

	findPath(lca, first, "", s1); 
	findPath(lca, second, "", s2); 
	if (s1.length() == 0 && s2.length() == 0) { 
	return -1; 
	} 
	s1.reverse(); 
	s1.append(s2); 
	int cnt = 0; 
	boolean flag = false; 
	for (int i = 0; i < (s1.length() - 1); i++) { 
	if (s1.charAt(i) != s1.charAt(i + 1)) { 
		flag = true; 
		cnt += 1; 
	} 
	} 
	if (!flag) { 
	return -1; 
	} 
	return cnt; 
} 


public static void main(String[] args) 
{ 
	
	
	Node root = newNode(1); 
	root.left = newNode(2); 
	root.right = newNode(3); 
	root.left.left = newNode(4); 
	root.left.right = newNode(5); 
	root.right.left = newNode(6); 
	root.right.right = newNode(7); 
	root.left.left.left = newNode(8); 
	root.right.left.left = newNode(9); 
	root.right.left.right = newNode(10); 

	System.out.println(numberOfTurns(root, 5, 10)); 
} 
} 


