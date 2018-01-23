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
    private int[] find(TreeNode root) {
        int[] ret = new int[2];
        if (root == null) {
            ret[0] = 0;
            ret[1] = 0;
            return ret;
        }
        int[] left = this.find(root.left), right = this.find(root.right);
        if (root.left != null) {
            ret[0] = Math.max(ret[0], left[0] + 1);
            ret[1] += left[0] + 1;
        }
        if (root.right != null) {
            ret[0] = Math.max(ret[0], right[0] + 1);
            ret[1] += right[0] + 1;
        }
        ret[1] = Math.max(ret[1], right[1]);
        ret[1] = Math.max(ret[1], left[1]);
        return ret;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return this.find(root)[1];
    }
}