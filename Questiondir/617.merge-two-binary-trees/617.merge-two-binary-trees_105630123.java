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
		TreeNode res = new TreeNode(0);
		if (t1 != null) res.val += t1.val;
		if (t2 != null) res.val += t2.val;
        res.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        res.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        return res;
    }
}