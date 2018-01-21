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
    public List<List<String>> printTree(TreeNode root) {
        int h = height(root), w = width(root);
        String[][] M = new String[h][w];
        for (int i = 0; i < h; ++i) Arrays.fill(M[i], "");
        recur(M, root, 0, w - 1, 0);
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < h; ++i) result.add(Arrays.asList(M[i]));
        return result;
    }
    
    void recur(String[][] M, TreeNode root, int l, int r, int level) {
        if (root == null) return;
        int mid = (l + r) / 2;
        M[level][mid] += root.val;
        recur(M, root.left, l, mid - 1, level + 1);
        recur(M, root.right, mid + 1, r, level + 1);
    }
    
    int width(TreeNode root) {
        int h = height(root);
        return (int) Math.pow(2, h) - 1;
    }
    
    int height(TreeNode root) {
        if (root == null) return 0;
        else return 1 + Math.max(height(root.left), height(root.right));
    }
}