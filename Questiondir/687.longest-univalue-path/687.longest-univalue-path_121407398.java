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

        int res = findPath(root.left, root.val) + findPath(root.right, root.val);
        int childRes = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(res, childRes);
    }

    int findPath(TreeNode node, int target) {
        if (node == null) return 0;

        if (node.val != target) return 0;
        return 1 + Math.max(findPath(node.left, target), findPath(node.right, target));
    }
}