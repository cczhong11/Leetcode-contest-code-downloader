/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode dfs(int[] a, int l, int r) {
        if (l > r) return null;
        int mid = l;
        for (int i = l; i <= r; i++)
            if (a[i] > a[mid])
                mid = i;
        TreeNode root = new TreeNode(a[mid]);
        root.left = dfs(a, l, mid - 1);
        root.right = dfs(a, mid + 1, r);
        return root;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }
}