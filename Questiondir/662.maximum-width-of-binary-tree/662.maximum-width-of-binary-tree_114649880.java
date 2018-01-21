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
    ArrayList<int[]> lvl;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        lvl = new ArrayList<>();
        dfs(root, 0, 0);
        int ans = 1;
        for (int[] a : lvl) {
            ans = Math.max(ans, a[1] - a[0] + 1);
        }
        return ans;
    }
    private void dfs(TreeNode root, int k, int c) {
        if (root == null) return;
        if (k == lvl.size()) lvl.add(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
        int[] cur = lvl.get(k);
        cur[0] = Math.min(cur[0], c);
        cur[1] = Math.max(cur[1], c);
        lvl.set(k, cur);
        dfs(root.left, k + 1, 2 * c);
        dfs(root.right, k + 1, 2 * c + 1);
    }
}