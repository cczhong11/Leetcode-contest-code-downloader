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
    public int longestUnivaluePath(TreeNode root) {
        return (root == null)? 0 : solve(root).get(1)-1;
    }
    private List<Integer> solve(TreeNode node) {
        List<Integer> list = Arrays.asList(1, 0);
        int len = 1;
        if (null != node.left) {
            List<Integer> sub = solve(node.left);
            if (node.left.val == node.val) {
                list.set(0, Math.max(list.get(0), 1+sub.get(0)));
                len += sub.get(0);
            }
            list.set(1, Math.max(list.get(1), sub.get(1)));
        }
        if (null != node.right) {
            List<Integer> sub = solve(node.right);
            if (node.right.val == node.val) {
                list.set(0, Math.max(list.get(0), 1+sub.get(0)));
                len += sub.get(0);
            }
            list.set(1, Math.max(list.get(1), sub.get(1)));
        }
        list.set(1, Math.max(list.get(1), len));
        return list;
    }
}