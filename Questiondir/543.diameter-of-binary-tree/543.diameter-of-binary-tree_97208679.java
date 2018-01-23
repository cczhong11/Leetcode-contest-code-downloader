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
    
    private int res;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        res = 0;
        if(null == root)
            return 0;
        utilHeight(root);
        return res-1;
    }
    
    private int utilHeight(TreeNode root){
        
        if(null == root)
            return 0;
        
        int l = utilHeight(root.left);
        int r = utilHeight(root.right);
        
        int height = Math.max(l, r) + 1;
        
        res = Math.max(res, l + r + 1);
        
        return height;
        
    }
    
}