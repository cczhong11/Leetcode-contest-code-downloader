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
    int answer;
    
    int f(int digit, TreeNode root) {
        if (root == null) return 0;
        if (root.val == digit) {
            int l = f(digit, root.left);
            int r = f(digit, root.right);
            answer = Math.max(answer, l + r);
            return 1 + Math.max(l, r);
        } else {
            int l = f(root.val, root.left);
            int r = f(root.val, root.right);
            answer = Math.max(answer, l + r);
            return 0;
        }
    }
    
    public int longestUnivaluePath(TreeNode root) {
        answer = 0;
        f(0, root);
        return answer;
    }
}