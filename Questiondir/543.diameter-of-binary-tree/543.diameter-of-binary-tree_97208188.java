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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max == 0 ? max : max - 1;
    }
    
    private int traverse(TreeNode root) {
        if(root == null) return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}