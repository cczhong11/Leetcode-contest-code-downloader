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
    TreeNode help(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[index]) index = i;
        }
        TreeNode ans = new TreeNode(nums[index]);
        ans.left = help(nums, start, index - 1);
        ans.right = help(nums, index + 1, end);
        return ans;
    }
}