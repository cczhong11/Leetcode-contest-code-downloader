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
	private List<Integer> list = new ArrayList<>();
	
    public boolean findTarget(TreeNode root, int k) {
     
    	if (root == null) {
    		return false;
    	}
    	dfs(root);
    	int i = 0 , j = list.size() - 1;
    	while (i < j) {
    		long sum = (long) list.get(i) + (long) list.get(j);
    		if (sum == (long) k) {
    			return true;
    		} else if (sum < (long) k) {
    			i ++;
    		} else {
    			j --;
    		}
    	}
    	return false;
    	
    }
    
    private void dfs(TreeNode root) {
    	
    	if (root.left != null) {
    		dfs(root.left);
    	}
    	list.add(root.val);
    	if (root.right != null) {
    		dfs(root.right);
    	}
    	
    }
}