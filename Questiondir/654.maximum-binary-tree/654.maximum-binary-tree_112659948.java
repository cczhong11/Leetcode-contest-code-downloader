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

        return construct(nums, 0, nums.length - 1);
    }
    TreeNode construct(int[] nums, int low, int high) {
        if (low > high) return null;
        int maxIndex = low - 1;
        for (int i = low; i <= high; i++) {
            if (maxIndex == low - 1 || nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = construct(nums, low, maxIndex - 1);
        node.right = construct(nums, maxIndex + 1, high);
        return node;
    }
}