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
            TreeNode res = new TreeNode(v);
            res.left = root;
            return res;
        }
        
        if (root == null) return null;
 
        if (d == 2) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        } else {
            addOneRow(root.left, v, d - 1);
            addOneRow(root.right, v, d - 1);
        }
        
        return root;
    }
}