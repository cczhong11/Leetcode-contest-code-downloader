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
        List<Double> res = new ArrayList<Double>();
        Map<Integer, List<Double>> m = new HashMap<Integer, List<Double>>();
        helper(m, root, 0);
        for (int i : m.keySet()) {
            double sum = 0;
            for (double d : m.get(i)) sum += d;
            sum = sum / m.get(i).size();
            res.add(sum);
        }
        return res;
    }
    public void helper(Map<Integer, List<Double>> m, TreeNode root, int depth) {
        if (root == null) return;
        if (!m.containsKey(depth)) m.put(depth, new ArrayList<Double>());
        m.get(depth).add((double)root.val);
        helper(m, root.right, depth + 1);
        helper(m, root.left, depth + 1);
    }
}