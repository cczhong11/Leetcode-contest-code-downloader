/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void dfs(TreeNode node, int level, int index, HashMap<Integer, Integer> min, HashMap<Integer, Integer> max) {
        if (node == null) return;
        if (min.containsKey(level)) {
            min.put(level, Math.min(min.get(level), index));
        } else {
            min.put(level, index);
        }
        if (max.containsKey(level)) {
            max.put(level, Math.max(max.get(level), index));
        } else {
            max.put(level, index);
        }
        dfs(node.left, level + 1, 2 * index, min, max);
        dfs(node.right, level + 1, 2 * index + 1, min, max);
    }
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, Integer> min = new HashMap<>();
        HashMap<Integer, Integer> max = new HashMap<>();
        dfs(root, 0, 0, min, max);
        int res = 0;
        for (int key : min.keySet()) {
            if (max.containsKey(key)) {
                res = Math.max(res, max.get(key) - min.get(key));
            }
        }
        return res + 1;
    }
}