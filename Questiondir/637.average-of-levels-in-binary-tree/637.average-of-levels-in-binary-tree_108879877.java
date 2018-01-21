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
    public List<Double> averageOfLevels(TreeNode root) {
		List<Double> averageVals = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		List<TreeNode> levelNodes = new ArrayList<>();
		queue.offer(root);
		levelNodes.add(root);
		while (!queue.isEmpty()) {
			if (queue.size() == levelNodes.size()) {
				long sum = 0;
				for (TreeNode node : levelNodes) {
					sum += node.val;
				}
				averageVals.add((double) sum / (double) levelNodes.size());
				levelNodes.clear();
			}
			TreeNode currNode = queue.poll();
			if (currNode.left != null) {
				queue.offer(currNode.left);
				levelNodes.add(currNode.left);
			}
			if (currNode.right != null) {
				queue.offer(currNode.right);
				levelNodes.add(currNode.right);
			}
		}
		return averageVals;
    }
}