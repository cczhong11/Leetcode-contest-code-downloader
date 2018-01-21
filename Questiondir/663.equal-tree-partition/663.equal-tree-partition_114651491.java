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
    int sum(TreeNode node, TreeSet<Integer> ts) {
        if (node == null) return 0;
        int res = node.val + sum(node.left, ts) + sum(node.right, ts);
        ts.add(res);
        return res;
    }

    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) return false;
        TreeSet<Integer> ts = new TreeSet<>();
        int want = sum(root, ts);
        if (want % 2 != 0) return false;
        want /= 2;
        return ts.contains(want);
    }
}