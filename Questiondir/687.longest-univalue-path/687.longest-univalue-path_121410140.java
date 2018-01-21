/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        return helper(root)-1;
    }
    int helper(TreeNode root){
        if (root == null) return 0;
        int l = 0, r = 0;
        if (root.left!=null&&root.left.val==root.val) l = dfs(root.left);
        if (root.right!=null&&root.right.val==root.val) r = dfs(root.right);
        return Math.max(Math.max(helper(root.left),helper(root.right)),1+l+r);
    }
    int dfs(TreeNode root){
        if (root == null) return 0;
        int l = 0, r = 0;
        if (root.left!=null&&root.left.val==root.val) l = dfs(root.left);
        if (root.right!=null&&root.right.val==root.val) r = dfs(root.right);
        return 1+Math.max(l,r);
    }
}