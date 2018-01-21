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
    public boolean checkEqualTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return false;
        int sum = calcSum(root);
        boolean []ans = new boolean[1];
        check(root, sum, ans);
        return ans[0];
    }

    int check(TreeNode rt, int target, boolean[] ans) {
        if (rt == null) return 0;
        int sum = check(rt.left, target, ans) + check(rt.right, target, ans) + rt.val;
        if (sum * 2 == target) {
            ans[0] = true;
        }
        return sum;
    }

    int calcSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + calcSum(root.left) + calcSum(root.right);
    }
}