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
    
    int total;
    
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        total = 0;
        modify(root);
        return root;
    }
    
    public void modify(TreeNode root){
        if(root.right!=null) modify(root.right);
        total += root.val;
        root.val = total;
        if(root.left!=null) modify(root.left);
    }
}