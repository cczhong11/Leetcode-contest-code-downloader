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
    Set<Integer> set;
    public boolean checkEqualTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return false;
        }
        set = new HashSet<>();
        int sum = dfs(root);
        // for (int k : set) {
        //     System.out.println(k);
        // }
        return sum % 2 == 0 && set.contains(sum / 2);
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        set.add(left);
        set.add(right);
        return left + right + root.val;
    }
}