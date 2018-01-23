/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        maxLen = 0;
        
        dfs(root);
        
        return maxLen - 1;
    }
    
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        
        int left  = dfs(root.left);
        int right = dfs(root.right);
        
        maxLen = Math.max(maxLen, left + right + 1);
        
        return Math.max(left, right) + 1;
    } 
}