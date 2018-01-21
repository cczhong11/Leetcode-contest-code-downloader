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
     
    	if (root == null) {
    		return Arrays.asList();
    	}
    	
    	List<Double> ans = new ArrayList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		double sum = 0;
    		int cnt = 0;
    		List<TreeNode> nextList = new ArrayList<>();
    		while (!queue.isEmpty()) {
    			TreeNode node = queue.poll();
    			sum += node.val;
    			cnt ++;
    			if (node.left != null) {
    				nextList.add(node.left);
    			}
    			if (node.right != null) {
    				nextList.add(node.right);
    			}
    		}
    		ans.add(sum / cnt);
    		for (TreeNode node : nextList) {
    			queue.add(node);
    		}
    	}
    	return ans;
    	
    }
}