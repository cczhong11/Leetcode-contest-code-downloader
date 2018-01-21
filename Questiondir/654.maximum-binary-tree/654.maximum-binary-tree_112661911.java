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
        if (nums == null || nums.length == 0) {
            return null;
        }
        return sub(nums, 0, nums.length - 1);
    }
    
    private TreeNode sub(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        
        int maxIdx = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        // System.out.println("maxIdx: " + maxIdx);
        TreeNode root = new TreeNode(nums[maxIdx]);
        // System.out.println("start: " + start + " maxIdx - 1: " + (maxIdx - 1));
        root.left = sub(nums, start, maxIdx - 1);
        root.right = sub(nums, maxIdx + 1, end);
        return root;
    }
}