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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        
        int val = getValue(t1) + getValue(t2);
        TreeNode root = new TreeNode(val);
        
        
        root.left = mergeTrees(getNode(t1, true), getNode(t2, true));
        root.right = mergeTrees(getNode(t1, false), getNode(t2, false));
        
        return root;
    }
    
    private int getValue(TreeNode root) {
        return root == null ? 0 : root.val;
    }
    
    private TreeNode getNode(TreeNode root, boolean left) {
        if (root == null) {
            return null;
        }
        
        return left ? root.left : root.right;
    }
}