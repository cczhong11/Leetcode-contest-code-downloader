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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }
        int a = findJustBigger(root, root.val);
        return a == Integer.MAX_VALUE ? -1 : a;
    }

    int findJustBigger(TreeNode root, int a) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        if(root.val == a) {
            return Math.min(findJustBigger(root.left, a), findJustBigger(root.right, a));
        }
        else {
            return root.val;
        }
    }
}