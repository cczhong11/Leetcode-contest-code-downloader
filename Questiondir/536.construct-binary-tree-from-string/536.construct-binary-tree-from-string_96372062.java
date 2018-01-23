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
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
    char[] cs;
    int idx, n;

    public TreeNode str2tree(String s) {
        if (s == null) return null;
        cs = s.toCharArray();
        idx = 0;
        n = cs.length;
        return dfs();
    }

    TreeNode dfs() {
        if (idx >= n) return null;
        long val = 0;
        boolean neg = false;
        TreeNode node = new TreeNode(0);
        while (idx < n && cs[idx] != ')') {
            if ('0' <= cs[idx] && cs[idx] <= '9') {
                val = val * 10 + cs[idx] - '0';
            } else if (cs[idx] == '(') {
                idx ++;
                if (node.left == null) {
                    node.left = dfs();
                } else {
                    node.right = dfs();
                }
            } else {
                if (cs[idx] == '-') neg = true;
            }
            idx ++;
        }
        if (neg) val = - val;
        node.val = (int) val;
        return node;
    }
}