/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        pathFromRoot(root);
        return max;
    }
    
    private int pathFromRoot(TreeNode root) {
        int ans = 0, l = 0, r = 0;
        if(root.left != null) {
            l = pathFromRoot(root.left) + 1;
            if(root.val == root.left.val) ans += l;
            else l = 0;
        }
        if(root.right != null) {
            r = pathFromRoot(root.right) + 1;
            if(root.val == root.right.val) ans += r;
            else r = 0;
        }
        max = Math.max(max, ans);
        if(l == 0 && r == 0) return 0;
        else return Math.max(l, r);
    }
}