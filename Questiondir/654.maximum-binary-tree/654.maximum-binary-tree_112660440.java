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
        int[][] max = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i][i] = i;
        }
        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i + len <= nums.length; i++) {
                if (nums[i] > nums[max[i + 1][i + len - 1]]) {
                    max[i][i + len - 1] = i;
                } else {
                    max[i][i + len - 1] = max[i + 1][i + len - 1];
                }
            }
        }
        return build(nums, max, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int[][] max, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = max[left][right];
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = build(nums, max, left, maxIndex - 1);
        node.right = build(nums, max, maxIndex + 1, right);
        return node;
    }
}