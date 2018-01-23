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
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0)
            return null;
        int ll = -1, lr = -1, rl = -1, rr = -1, lc = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lc++;
                if (ll == -1) {
                    ll = i;
                } else if (lr != -1 && rl == -1) {
                    rl = i;
                }
            } else if (s.charAt(i) == ')') {
                lc--;
                if (lc == 0) {
                    if (lr == -1) {
                        lr = i;
                    } else {
                        rr = i;
                    }
                }
            }
        }
        int r = Integer.parseInt(s.substring(0, ll == -1 ? s.length() : ll));
        TreeNode root = new TreeNode(r);
        if (lr != -1)
            root.left = str2tree(s.substring(ll+1, lr));
        if (rr != -1)
            root.right = str2tree(s.substring(rl+1, rr));
        return root;
    }
}