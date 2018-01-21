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
        return recur(nums, 0, nums.length);
    }
    
    TreeNode recur(int[] nums, int l, int r) {
        // System.out.println(l + ", " + r);
        if (l >= r) return null;
        int max_index = l;
        for (int i = l; i < r; ++i) {
            if (nums[i] > nums[max_index]) max_index = i;
        }
        TreeNode ret = new TreeNode(nums[max_index]);
        ret.left = recur(nums, l, max_index);
        ret.right = recur(nums, max_index + 1, r);
        return ret;
    }
}