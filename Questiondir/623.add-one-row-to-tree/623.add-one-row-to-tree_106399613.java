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
    	if(d == 1) {
    		TreeNode newRoot = new TreeNode(v);
    		newRoot.left = root;
    		return newRoot;
    	}
    	if(root == null) return root;
    	List<TreeNode> list = new ArrayList<>();
    	list.add(root);
    	for(int i = 0; i < d - 2; i ++) {
    		List<TreeNode> newList = new ArrayList<>();
    		for(TreeNode node : list) {
    			if(node.left != null) newList.add(node.left);
    			if(node.right != null) newList.add(node.right);
    		}
    		list = newList;
    	}
    	
    	for(TreeNode node : list) {
    		TreeNode prevLeft = node.left;
    		TreeNode prevRight = node.right;
    		node.left = new TreeNode(v);
    		node.right = new TreeNode(v);
    		node.left.left = prevLeft;
    		node.right.right = prevRight;
    	}
    	return root;
        
    }
}