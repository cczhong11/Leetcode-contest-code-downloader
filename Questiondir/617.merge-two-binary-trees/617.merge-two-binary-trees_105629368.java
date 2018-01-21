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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	
    	return dfs(t1 , t2);
        
    }
    
    private TreeNode dfs(TreeNode node1 , TreeNode node2) {
    	
    	if (node1 == null && node2 == null) {
    		return null;
    	} else {
    		if (node1 != null && node2 != null) {
    			TreeNode ans = new TreeNode(node1.val + node2.val);
    			ans.left = dfs(node1.left , node2.left);
    			ans.right = dfs(node1.right , node2.right);
    			return ans;
    		} else if (node1 != null) {
    			TreeNode ans = new TreeNode(node1.val);
    			ans.left = dfs(node1.left , null);
    			ans.right = dfs(node1.right , null);
    			return ans;
    		} else if (node2 != null) {
    			TreeNode ans = new TreeNode(node2.val);
    			ans.left = dfs(null , node2.left);
    			ans.right = dfs(null , node2.right);
    			return ans;
    		} else {
    			return null;
    		}
    	}
    	
    }

}