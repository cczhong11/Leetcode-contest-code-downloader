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
        TreeNode dummyRoot = new TreeNode(0);
        dummyRoot.left=root;
        helper(dummyRoot, v, d, 1);
        return dummyRoot.left;
    }
    
    private void helper (TreeNode root, int v, int d, int level){
        if(root==null) return;
        if(level==d){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(v);
            root.right = new TreeNode(v);
            root.left.left = left;
            root.right.right = right;
        }
        else{
            helper(root.left, v, d, level+1);
            helper(root.right, v, d, level+1);
        }
        
        
    } 
}