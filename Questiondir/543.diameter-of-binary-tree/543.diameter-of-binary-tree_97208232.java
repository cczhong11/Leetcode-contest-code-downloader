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
    
    int diam;
    
    public int diameterOfBinaryTree(TreeNode root) {
        diam = 0;
        if(root==null) return 0;
        findPath(root);
        return diam - 1;
    }
    
    public int findPath(TreeNode root){
        int left = 0, right = 0;
        if(root.left!=null) left = findPath(root.left);
        if(root.right!=null) right = findPath(root.right);
        int tmp = left + 1 + right;
        if(tmp>diam) diam = tmp;
        return Math.max(left, right) + 1;
    }
}