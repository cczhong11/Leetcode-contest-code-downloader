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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode r = new TreeNode(v);
            r.left = root;
            return r;
        }
        add(root, v, d);
        return root;
    }
    void add(TreeNode root, int v, int d) {
        if (root == null) return;
        if (d > 2) {
            add(root.left, v, d-1);
            add(root.right, v, d-1);
        } else {
                TreeNode r1 = new TreeNode(v);
                r1.left = root.left;
                root.left = r1;
                TreeNode r2 = new TreeNode(v);
                r2.right = root.right;
                root.right = r2;
        }
    }
}