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
        TreeNode root = null;
        if(s.length() > 0) {
            int tail = s.indexOf('(');
            if(tail == -1) {
                int v = Integer.valueOf(s);
                root = new TreeNode(v);
            } else {
                int v = Integer.valueOf(s.substring(0, tail));
                root = new TreeNode(v);
                int cnt = 1;
                int j = tail+1;
                while(j < s.length()) {
                    if(s.charAt(j) == '(') {
                        cnt++;
                    } else if(s.charAt(j) == ')') {
                        cnt--;
                    }
                    j++;
                    if(cnt == 0) {
                        break;
                    }
                }
                String leftStr = s.substring(tail+1, j-1);
                root.left = str2tree(leftStr);
                if(j < s.length()) {
                    String rightStr = s.substring(j+1, s.length()-1);
                    root.right = str2tree(rightStr);
                }
            }
        }
        return root;
    }
}