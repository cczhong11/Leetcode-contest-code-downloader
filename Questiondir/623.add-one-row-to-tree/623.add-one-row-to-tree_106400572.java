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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        
    	if (d == 1) {
    		TreeNode ans = new TreeNode(v);
    		ans.left = root;
    		return ans;
    	} else {
    		return dfs(root , v , d);
    	}
    	
    }
    
    private TreeNode dfs(TreeNode root , int v , int d) {
    	
    	if (d == 2) {
    		TreeNode node1 = new TreeNode(v);
    		TreeNode node2 = new TreeNode(v);
    		TreeNode left = root.left , right = root.right;
    		node1.left = left;
    		node2.right = right;
    		root.left = node1;
    		root.right = node2;
    		return root;
    	} else {
    		if (root.left != null) {
    			dfs(root.left , v , d - 1);
    		}
    		if (root.right != null) {
    			dfs(root.right , v , d - 1);
    		}
    		return root;
    	}
    	
    }
}