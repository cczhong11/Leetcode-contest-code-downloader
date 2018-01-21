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
	 int max = 0;


	 private int findMax(TreeNode node) {
		 
		 int l = 0;
		 int r = 0;
		 if (node.left!=null) {
			 l = findMax(node.left);
			 if (node.left.val!=node.val) {
				 l = 0;
			 }
		 }
		 if (node.right!=null) {
			 r = findMax(node.right);
			 if (node.right.val!=node.val) {
				 r = 0;
			 }
		 }
		 this.max = Math.max(max, l+r);
		 return Math.max(l, r)+1;
		 
		 
	 }
    
    	 public int longestUnivaluePath(TreeNode root) {
	     if (root == null) {
	    	 return 0;
	     }
		 findMax(root);
	     return this.max;
	 }
	
}