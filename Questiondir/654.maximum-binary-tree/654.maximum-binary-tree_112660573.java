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
    private TreeNode build(int[] nums, int left, int right){
        if(left > right) return null;
        int max = left;
        for(int i = left + 1;i<=right;i++){
            if(nums[i] > nums[max]) max = i;
        }

        TreeNode node = new TreeNode(nums[max]);
        node.left = build(nums,left,max - 1);
        node.right = build(nums,max + 1,right);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums,0,nums.length - 1);
    }
}