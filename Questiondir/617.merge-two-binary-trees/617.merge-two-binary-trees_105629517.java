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
        if(t1 != null && t2 != null){
            TreeNode left = mergeTrees(t1.left, t2.left);
            TreeNode right = mergeTrees(t1.right, t2.right);
            t1.val += t2.val;
            t1.left = left;
            t1.right = right;
            return t1;
        }else if(t1 == null && t2 == null)
            return  null;
        else
            return t1 == null ? t2 : t1;
    }
}