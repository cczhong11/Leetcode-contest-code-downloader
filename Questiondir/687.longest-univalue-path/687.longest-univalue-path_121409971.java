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
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }
    
    public int[] dfs(TreeNode root) {
        if (root == null) return new int[2];
        int l, r;
        int[] a = dfs(root.left), b = dfs(root.right);
        if (root.left == null || root.left.val != root.val) l = 1;
        else l = Math.max(a[0], a[1]) + 1;
        if (root.right == null || root.right.val != root.val) r = 1;
        else r = Math.max(b[0], b[1]) + 1;
        int[] res = new int[2];
        res[0] = l;
        res[1] = r;
        if (l + r - 2 > max) max = l + r - 2;
        return res;
    }
}