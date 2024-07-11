//Unique BST

import java.util.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int numTrees(int N) {

        int[] dp = new int[N + 1];
    
        dp[0] = 1;
        dp[1] = 1;
        
        // Fill the dp array for each count of nodes from 2 to N
        for (int nodes = 2; nodes <= N; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                // Number of unique BST with 'nodes' nodes is the sum of
                // leftSubtree * rightSubtree for each possible root
                int leftSubtree = dp[root - 1];
                int rightSubtree = dp[nodes - root];
                dp[nodes] += leftSubtree * rightSubtree;
            }
        }
        
        // Return the number of unique BST for 'N' nodes
        return dp[N];
    }
}

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.numTrees(n));
        }
    }
}
