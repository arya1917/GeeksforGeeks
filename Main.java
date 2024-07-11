//Count all k-sum paths in a Binary Tree
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        value = val;
    }
}

public class Main {
    public static List<Integer> dfs_k_path_sum(TreeNode root, int k) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> leftPaths = dfs_k_path_sum(root.left, k);
        List<Integer> rightPaths = dfs_k_path_sum(root.right, k);

        List<Integer> allPaths = new ArrayList<>(leftPaths);
        allPaths.addAll(rightPaths);
        allPaths.add(root.value);

        List<Integer> paths = new ArrayList<>();
        for (int i = 0; i < allPaths.size(); i++) {
            for (int j = i; j < allPaths.size(); j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += allPaths.get(l);
                }
                if (sum == k)
                    paths.add(sum);
            }
        }

        return paths;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node3 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        node2.left = node3;
        node2.right = node4;
        TreeNode node11 = new TreeNode(6);
        TreeNode node10 = new TreeNode(5);
        node10.right = node11;
        TreeNode node9 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        TreeNode node7 = new TreeNode(4);
        node7.left = node8;
        node7.right = node9;
        TreeNode node6 = new TreeNode(-1);
        node6.left = node7;
        node6.right = node10;
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node6;

        int k = 5;
        List<Integer> paths = dfs_k_path_sum(node1, k);
        System.out.println("Paths: " + paths);
    }
}
