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
        Queue<TreeNode> buf = new LinkedList<>();
        if(root != null) buf.offer(root);
        while(!buf.isEmpty()) {
            Double val = 0.0, count = 0.0;
            for(int i = buf.size(); i > 0; --i) {
                TreeNode curr = buf.poll();
                val += curr.val;
                count += 1.0;
                if(curr.left!=null) buf.offer(curr.left);
                if(curr.right!=null) buf.offer(curr.right);
            }
            ans.add(val/count);
        }
        return ans;
    }
}