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
        int[] ans = dfs(root);
        return ans[0];
    }
    int[] dfs(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) {
            return ans;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int currAns = 0;
        ans[0] = Math.max(ans[0], left[0]);
        if (root.left != null && root.left.val == root.val) {
            currAns += left[1] + 1;
            ans[1] = Math.max(ans[1], left[1] + 1);
        }
        ans[0] = Math.max(ans[0], right[0]);
        if (root.right != null && root.right.val == root.val) {
            currAns += right[1] + 1;
            ans[1] = Math.max(ans[1], right[1] + 1);
        }
        ans[0] = Math.max(ans[0], currAns);
        // System.out.println(root.val + " " + ans[0] + " " + ans[1]);
        return ans;
    }
}