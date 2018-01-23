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
        if (s == null || s.length() == 0) {
            return null;
        }
        boolean negative = false;
        int num = 0;
        TreeNode res = null;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                negative = true;
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                int start = i + 1;
                int open = 1;
                i++;
                while (i < s.length() && open > 0) {
                    if (s.charAt(i) == '(') {
                        open++;
                    } else if (s.charAt(i) == ')') {
                        open--;
                    }
                    i++;
                }
                TreeNode child = str2tree(s.substring(start, i-1));
                if (res == null) {
                    // left child
                    res = new TreeNode(negative ? -num : num);
                    res.left = child;
                } else {
                    res.right = child;
                }
                i--;
            }
        }
        if (res == null) {
            res = new TreeNode(negative ? -num : num);
        }
        return res;
    }
}