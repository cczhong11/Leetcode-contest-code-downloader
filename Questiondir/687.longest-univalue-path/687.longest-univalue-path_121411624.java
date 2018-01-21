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
	 
	int final_res = 0;
	
	int rec(TreeNode root) {
		if (root == null) return 0;
		
		int ret = 1, tmp = 1;

        int d1 = rec(root.left);
		if (root.left != null && root.left.val == root.val) {
			int d = d1;
			ret = Math.max(ret, d + 1);
			tmp += d;
		}
        
        int d2 = rec(root.right);
		if (root.right != null && root.right.val == root.val) {
			int d = d2;
			ret = Math.max(ret, d + 1);
			tmp += d;
		}
		
		final_res = Math.max(final_res, tmp);
		return ret;
	}
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        rec(root);
        return final_res - 1;
    }
}