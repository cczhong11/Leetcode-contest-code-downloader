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
     
    	return dfs(nums , 0 , nums.length - 1);
    	
    }
    
    private TreeNode dfs(int[] nums , int from , int to) {
    	
    	if (from > to) {
    		return null;
    	} else {
    		int max = nums[from] , index = from;
    		for (int i = from;i <= to;i ++) {
    			if (nums[i] > max) {
    				max = nums[i];
    				index = i;
    			}
    		}
    		TreeNode root = new TreeNode(max);
    		root.left = dfs(nums , from , index - 1);
    		root.right = dfs(nums , index + 1 , to);
    		return root;
    	}
    	
    }
}