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
        return buildTree(nums,0,nums.length);
    }
    
    private TreeNode buildTree(int[] nums, int lo, int hi){
        if (lo>=hi)
            return null;
        int maxIdx = lo;
        for (int i=lo+1;i<hi;i++){
            if (nums[i]>nums[maxIdx]){
                maxIdx = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = buildTree(nums, lo, maxIdx);
        root.right = buildTree(nums, maxIdx+1, hi);
        return root;
    }
}