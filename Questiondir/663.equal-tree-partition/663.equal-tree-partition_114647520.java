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
    public int getsum(TreeNode root) {
        if (root == null) return 0;
        root.val += getsum(root.left) + getsum(root.right);
        return root.val;
    }
    public boolean check(TreeNode root, int val) {
        if (root == null) return false;
        return root.val == val || check(root.left, val) || check(root.right, val);
    }
    public boolean checkEqualTree(TreeNode root) {
        getsum(root);
        return (root.left != null || root.right != null) && root.val % 2 == 0 && 
        check(root, root.val / 2);
    }
}