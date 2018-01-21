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
        int d = getMaxDepth(root, 0);
        int width = 0;
        for (int i = 0; i < d; i++) {
            width = (width << 1) + 1;
        }
        List<List<String>> grid = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add("");
            }
            grid.add(row);
        }
        help(grid, root, 0, 0, width - 1);
        return grid;
    }
    
    public int getMaxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(getMaxDepth(node.left, depth + 1), getMaxDepth(node.right, depth + 1));
    }
    
    public void help(List<List<String>> grid, TreeNode node, int row, int L, int R) {
        if (node == null) {
            return;
        }
        int idx = (L + R) / 2;
        grid.get(row).set(idx, Integer.toString(node.val));
        help(grid, node.left, row + 1, L, idx - 1);
        help(grid, node.right, row + 1, idx + 1, R);
    }
}