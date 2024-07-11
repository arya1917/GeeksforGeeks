//Print all nodes at distance k from a given node


class Node 
{
    int data;
    Node left, right;
 
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
 
class BinaryTree 
{
    Node root;
    
 
    void printkdistanceNodeDown(Node node, int k) 
    {
        
        if (node == null || k < 0)
            return;
 
        if (k == 0) 
        {
            System.out.print(node.data);
            System.out.println("");
            return;
        }
 
        printkdistanceNodeDown(node.left, k - 1);
        printkdistanceNodeDown(node.right, k - 1);
    }
 
   
    int printkdistanceNode(Node node, Node target, int k) 
    {
        if (node == null)
            return -1;
 
        t
        if (node == target) 
        {
            printkdistanceNodeDown(node, k);
            return 0;
        }
 
        
        int dl = printkdistanceNode(node.left, target, k);
 
        
        if (dl != -1) 
        {
             
            if (dl + 1 == k) 
            {
                System.out.print(node.data);
                System.out.println("");
            }
             
            else
                printkdistanceNodeDown(node.right, k - dl - 2);
 
           s
            return 1 + dl;
        }
 
      
        int dr = printkdistanceNode(node.right, target, k);
        if (dr != -1) 
        {
            if (dr + 1 == k) 
            {
                System.out.print(node.data);
                System.out.println("");
            } 
            else 
                printkdistanceNodeDown(node.left, k - dr - 2);
            return 1 + dr;
        }
 
        
        return -1;
    }
 
    public static void main(String args[]) 
    {
        BinaryTree tree = new BinaryTree();
 
       
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        Node target = tree.root.left.right;
        tree.printkdistanceNode(tree.root, target, 2);
    }
}
 
