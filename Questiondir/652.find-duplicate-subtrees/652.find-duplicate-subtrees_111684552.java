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
	Map<String, Boolean> outputed = new HashMap<String, Boolean>();
	Map<String, TreeNode> place = new HashMap<String, TreeNode>();
	List<TreeNode> ans = new ArrayList<TreeNode>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         // somehow hash a subtree?
		go(root);
		return ans;
    }
	
	public String go(TreeNode node) {
		if(node == null) return "N";
		StringBuilder sb = new StringBuilder();
		String left = go(node.left);
		String right = go(node.right);
		sb.append("[");
        sb.append(left);
        sb.append(",");
		sb.append(node.val);
        sb.append(",");
		sb.append(right);
        sb.append("]");
		String ret = sb.toString();
        
		if(place.containsKey(ret) && !outputed.containsKey(ret)) {
			ans.add(node);
			outputed.put(ret, true);
		}
		
		place.put(ret, node);
		return sb.toString();
	}
}