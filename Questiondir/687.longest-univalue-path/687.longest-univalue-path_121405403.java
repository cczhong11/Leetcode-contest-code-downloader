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
private int ans = 0;
	
    public int longestUnivaluePath(TreeNode root) {
     
    	if (root == null) {
    		return 0;
    	} else {
    		ans = 0;
    		dfs(root);
    		return ans;
    	}
    	
    }
    
    private int dfs(TreeNode root) {
    	
    	if (root.left == null && root.right == null) {
    		return 1;
    	} else {
    		if (root.left != null && root.right != null) {
    			int h1 = dfs(root.left) , h2 = dfs(root.right) , h = 1;
    			int temp = 1;
    			if (root.left.val == root.val) {
    				temp += h1;
    				if (h1 + 1 > h) {
    					h = h1 + 1;
    				}
    			}
    			if (root.right.val == root.val) {
    				temp += h2;
    				if (h2 + 1 > h) {
    					h = h2 + 1;
    				}
    			}
    			if (temp - 1 > ans) {
    				ans = temp - 1;
    			}
    			return h;
    		} else if (root.left != null) {
    			int h = 1 , temp = dfs(root.left);
    			if (root.left.val == root.val) {
    				if (temp + 1 > h) {
    					h = temp + 1;
    				}
    			}
    			if (h - 1 > ans) {
    				ans = h - 1;
    			}
    			return h;
    		} else {
    			int h = 1 , temp = dfs(root.right);
    			if (root.right.val == root.val) {
    				if (temp + 1 > h) {
    					h = temp + 1;
    				}
    			}
    			if (h - 1 > ans) {
    				ans = h - 1;
    			}
    			return h;
    		}
    	}
    	
    }
}