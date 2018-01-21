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
        List<Double> result = new ArrayList<>();
        if(root == null)  return result;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()) {
            long size = qu.size();
            long sum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode cur = qu.remove();
                sum += (long)(cur.val);
                if(cur.left != null)  qu.add(cur.left);
                if(cur.right != null)  qu.add(cur.right);
            }
            result.add((double)sum / size);
        }
        return result;
    }
}