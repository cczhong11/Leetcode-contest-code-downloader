public class Solution {

	private List<TreeNode> list = new ArrayList<TreeNode>();
	
	public String findContestMatch(int n) {

		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(null);
		for (int i = 1;i <= n;i ++) {
			list.add(new TreeNode(i));
		}
		int total = n;
		while (total > 1) {
			List<TreeNode> next = new ArrayList<TreeNode>();
			next.add(null);
			for (int i = 1;i <= total / 2;i ++) {
				TreeNode node = new TreeNode(- 1);
				node.left = list.get(i);
				node.right = list.get(total - i + 1);
				next.add(node);
			}
			total /= 2;
			list = next;
		}
		return dfs(list.get(1));
		
    }

	private String dfs(TreeNode root) {
		
		if (root.left == null && root.right == null) {
			return root.val + "";
		} else {
			String left = dfs(root.left);
			String right = dfs(root.right);
			return "(" + left + "," + right + ")";
		}
		
	}

}