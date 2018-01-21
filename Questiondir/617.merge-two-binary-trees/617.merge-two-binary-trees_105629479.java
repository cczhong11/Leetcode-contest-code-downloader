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
        if (t1 == null && t2 == null) return null;
        if (t1 == null) return copyTree(t2);
        if (t2 == null) return copyTree(t1);
        
        TreeNode rt = new TreeNode(t1.val + t2.val);
        rt.left = mergeTrees(t1.left, t2.left);
        rt.right = mergeTrees(t1.right, t2.right);
        return rt;
    }
    
    TreeNode copyTree(TreeNode t) {
        if (t == null) return null;
        TreeNode rt = new TreeNode(t.val);
        rt.left = copyTree(t.left);
        rt.right = copyTree(t.right);
        return rt;
    }
}