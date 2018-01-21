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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }
    
    public TreeNode help(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        int idx = L;
        for (int i = L + 1; i <= R; ++i) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        TreeNode node = new TreeNode(nums[idx]);
        node.left = help(nums, L, idx - 1);
        node.right = help(nums, idx + 1, R);
        return node;
    }
}