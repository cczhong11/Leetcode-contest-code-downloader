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
 	int ans = 0;
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
        if (ans == 0) {
            return 0;
        } else {
            return ans - 1;
        }
	}
	
	int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int a = 0;
		int b = 0;
		if (root.left != null) {
			if (root.left.val == root.val) {
				a = dfs(root.left);
			} else {
				dfs(root.left);
			}
		}
		if (root.right != null) {
			if (root.right.val == root.val) {
				b = dfs(root.right);
			} else {
				dfs(root.right);
			}
		} 
		int ret = Math.max(a, b) + 1;
		ans = Math.max(ans, a + b + 1);
		return ret;
	}
}