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
        if(s == null) return null;
        char[] str = s.toCharArray();
        return helper(str, 0, str.length - 1);
    }
    TreeNode helper(char[] str, int start, int end) {
        if(start > end) return null;
        boolean isNegative = false;
        if(str[start] == '-') {
            isNegative = true;
            start++;
        }
        long num = 0;
        int i = start;
        for(; i <= end && str[i] != '('; i++) {
            num = num * 10 + str[i] - '0';
        }
        num = isNegative ? -num : num;
        TreeNode root = new TreeNode((int)num);
        if(i > end) return root;
        int j = i + 1;
        int left = 1;
        while(left != 0) {
            if(str[j] == '(') left++;
            else if(str[j] == ')') left--;
            j++;
        }
        root.left = helper(str, i + 1, j - 2);
        root.right = helper(str, j + 1, end - 1);
        return root;
    }
}