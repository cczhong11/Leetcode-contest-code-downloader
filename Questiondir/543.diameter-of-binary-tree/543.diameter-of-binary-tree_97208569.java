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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[]ans = dfs(root);
        return ans[0] - 1;
    }
    
    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] ans = new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        ans[1] = Math.max(left[1], right[1]) + 1;
        ans[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1] + 1);
        return ans;
    }
}