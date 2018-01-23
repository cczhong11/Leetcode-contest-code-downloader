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
        if (s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '-' || Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
                    i ++;
                }
                int val = Integer.parseInt(s.substring(start, i));
                TreeNode node = new TreeNode(val);
                connect(stack, node);
                i -= 1;
            } else if (c == ')'){
                stack.pop();
            }
        }
        return stack.peek();
    }

    private void connect(Stack<TreeNode> stack, TreeNode node) {
        if (stack.size() != 0) {
            TreeNode father = stack.peek();
            if (father.left == null) {
                father.left = node;
            } else {
                father.right = node;
            }
        }
        stack.push(node);
    }
}