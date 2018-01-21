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
    
    private boolean res = false;
    public boolean checkEqualTree(TreeNode root) {
        int t = sum(root, 0);
        res = false;
        if (root.left != null) {
            sum(root.left, t);
        }
        
        if (root.right != null) {
            sum(root.right, t);
        }
        
        return res;
    }
    
    int sum(TreeNode node, int t) {
        if (node == null) {
            return 0;
        }
        
        int s = sum(node.left, t) + sum(node.right, t) + node.val;
        
        if (s * 2 == t) res = true;
        
        return s;
        
    }
}