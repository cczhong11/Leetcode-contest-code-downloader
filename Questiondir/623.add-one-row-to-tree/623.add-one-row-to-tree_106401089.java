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
        return add(root, v, d, true);
    }
    private TreeNode add(TreeNode root, int v, int d, boolean left) {
        if(d == 1) {
            TreeNode curr = new TreeNode(v);
            if(left)
                curr.left = root;
            else
                curr.right = root;
            return curr;
        }
        else {
            if(root == null) return null;
            TreeNode curr = new TreeNode(root.val);
            curr.left = add(root.left, v, d-1, true);
            curr.right = add(root.right, v, d-1, false);
            return curr;
        }
    }
}