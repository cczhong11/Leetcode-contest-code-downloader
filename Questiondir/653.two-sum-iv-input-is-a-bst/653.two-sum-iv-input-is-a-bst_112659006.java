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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> s = new HashSet<>();
        dfs(root, s);
        for (Integer i : s) if (k - i != i && s.contains(k - i)) {
            return true;
        }
        return false;
    }
    private void dfs(TreeNode root, Set<Integer> s) {
        if (root == null) {
            return;
        }
        s.add(root.val);
        dfs(root.left, s);
        dfs(root.right, s);
    }
}