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
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int l, int r) {
        if (r < l) return null;
        if (r == l) return new TreeNode(nums[l]);

        int maxVal = nums[r];
        int idx = r;
        for (int i = r - 1; i >= l; i--) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                idx = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, l, idx - 1);
        root.right = build(nums, idx + 1, r);
        return root;
    }
}