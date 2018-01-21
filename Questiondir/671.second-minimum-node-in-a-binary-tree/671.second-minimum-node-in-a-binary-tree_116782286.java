/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
    		if(root == null) return -1;
    		if(root.left == null && root.right == null) return -1;
    		
    		int left = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
    		int right = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
    		
    		if(left == -1) return right;
    		else if(right == -1) return left;
    		else return Integer.min(left, right);
    }
}