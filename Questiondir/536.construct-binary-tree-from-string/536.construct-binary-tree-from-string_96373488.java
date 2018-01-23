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
        char[] array = s.toCharArray();
        Deque<TreeNode> stack = new ArrayDeque<>();
        int start = 0, length = array.length;
        TreeNode cur = null;
        while (start < length) {
            if (array[start] == '(') {
                stack.addFirst(cur);
                start++;
            } else if (array[start] == ')') {
                if (stack.peek().left == null) stack.peek().left = cur;
                else stack.peek().right = cur;
                cur = stack.poll();
                start++;
            } else {
                int next = start + 1;
                while (next < length && array[next] != '(' && array[next] != ')') next++;
                int val = Integer.valueOf(new String(array, start, next - start));
                cur = new TreeNode(val);
                start = next;
            }
        }
        return cur;
    }
}