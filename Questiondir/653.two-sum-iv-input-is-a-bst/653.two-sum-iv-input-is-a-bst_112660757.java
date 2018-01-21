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
    public boolean findTarget(TreeNode root, int k) {
        return check(root, root, k);
    }
    
    boolean check(TreeNode root, TreeNode first, int k) {
        if (first == null) return false;
        return find(first, root, k - first.val) || check(first.left, root, k) || check(first.right, root, k);
    }
    
    boolean find(TreeNode first, TreeNode second, int k) {
        if (second == null) return false;
        
        if (first != second && second.val == k) return true;
        return find(first, second.left, k) || find(first, second.right, k);
    }
}