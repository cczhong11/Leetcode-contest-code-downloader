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
        if ( t1 == null && t2 == null )
            return null;
        if ( t1 == null && t2 != null ) {
            TreeNode l = t2.left, r = t2.right;
            TreeNode x = new TreeNode(t2.val);
            x.left = l; x.right = r;
            return x;
        }
        if ( t1 != null && t2 == null ) {
            TreeNode l = t1.left, r = t1.right;
            TreeNode x = new TreeNode(t1.val);
            x.left = l; x.right = r;
            return x;
        }
        if ( t1 != null && t2 != null ) {
            TreeNode l = mergeTrees(t1.left,t2.left), r = mergeTrees(t1.right,t2.right);
            TreeNode x = new TreeNode(t1.val+t2.val);
            x.left = l; x.right = r;
            return x;
        }
        return null;
    }
}