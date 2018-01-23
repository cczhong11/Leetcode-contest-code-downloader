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

	private List<TreeNode> list = new ArrayList<TreeNode>();
	private List<Integer> ans = new ArrayList<Integer>();
	
	public TreeNode convertBST(TreeNode root) {
     
		if (root == null) {
			return null;
		}
		
		list.clear();
		ans.clear();
		dfs(root);
		int sum = 0;
		for (int i = 0;i < list.size();i ++) {
			sum += list.get(i).val;
		}
		for (int i = 0;i < list.size();i ++) {
			int from = i , to = i;
			while (i < list.size() && list.get(i).val == list.get(from).val) {
				sum -= list.get(i).val;
				to = i;
				i ++;
			}
			i --;
			for (int j = from;j <= to;j ++) {
				ans.add(sum + list.get(from).val);
			}
		}
		for (int i = 0;i < list.size();i ++) {
			list.get(i).val = ans.get(i);
		}
		return root;
		
    }
	
	private void dfs(TreeNode root) {
		
		if (root == null) {
			return;
		} else {
			dfs(root.left);
			list.add(root);
			dfs(root.right);
		}
		
	}

}