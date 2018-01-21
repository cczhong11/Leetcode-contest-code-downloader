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
        List<Double> ans = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>(), next = new ArrayDeque<>(), temp;
        next.push(root);
        while (!next.isEmpty()) {
            temp = next;
            next = queue;
            queue = temp;
            double sum = 0;
            int cnt = queue.size();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            ans.add(sum / cnt);
        }
        return ans;
    }

}