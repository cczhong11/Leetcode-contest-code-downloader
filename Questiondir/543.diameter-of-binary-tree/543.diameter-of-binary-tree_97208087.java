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

	private int ans = 0;
	
    public int diameterOfBinaryTree(TreeNode root) {
        
    	if (root == null) {
    		return 0;
    	} else {
    		ans = 0;
    		dfs(root);
    		return ans;
    	}
    	
    }
    
    private int dfs(TreeNode root) {
    	
    	if (root == null) {
    		return 0;
    	} else {
    		int h1 = dfs(root.left) , h2 = dfs(root.right);
    		int temp = h1 + h2 + 1 - 1;
    		if (temp > ans) {
    			ans = temp;
    		}
    		return Math.max(h1 , h2) + 1;
    	}
    	
    }

}