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
			TreeNode newRoot = new TreeNode(v);
			newRoot.left = root;
			return newRoot;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<TreeNode> currLevel = Arrays.asList(root);
		int level = 0;
		while (!queue.isEmpty()) {
			if (currLevel.size() == queue.size()) {
				level += 1;
				if (level == d - 1) {
					for (TreeNode node : currLevel) {
						TreeNode origLeft = node.left;
						TreeNode origRight = node.right;
						TreeNode newLeft = new TreeNode(v);
						newLeft.left = origLeft;
						TreeNode newRight = new TreeNode(v);
						newRight.right = origRight;
						node.left = newLeft;
						node.right = newRight;
					}
					break;
				}
				currLevel = new ArrayList<>();
			}
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				currLevel.add(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
				currLevel.add(node.right);
			}
		}
		return root;
    }
}