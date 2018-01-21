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
    int min = -1;
    int secMin = -1;
    public int findSecondMinimumValue(TreeNode root) {
        min = secMin = -1;
        dfs(root);
        return secMin;
    }
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (root.val == min || root.val == secMin) {   
        } else if (min < 0 || root.val < min) {
            secMin = min;
            min = root.val;
        } else if (secMin < 0 || root.val < secMin) {
            secMin = root.val;
        }
        dfs(root.right);
    }
}