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
    public TreeNode help(TreeNode a, TreeNode b) {
        if (a == null && b == null) return null;
        int aVal = (a == null ? 0 : a.val);
        int bVal = (b == null ? 0 : b.val);
        TreeNode here = new TreeNode(aVal + bVal);
        here.left = help(a == null ? null : a.left, b == null ? null : b.left);
        here.right = help(a == null ? null : a.right, b == null ? null : b.right);
        return here;
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return help(t1, t2);
    }
}