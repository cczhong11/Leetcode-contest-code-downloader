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
        if (root == null) {
            return null;
        }
        int m = getDepth(root);
        int n = (1 << m) - 1;
        String[][] arr = new String[m][n];
        dfs(arr, 0, 0, n - 1, root);
        
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == null) {
                    row.add("");
                } else {
                    row.add(arr[i][j]);
                }
            }
            res.add(row);
        }
        return res;
    }
    
    private void dfs(String[][] arr, int row, int left, int right, TreeNode node) {
        if (node == null) {
            return;
        }
        int col = (left + right) / 2;
        arr[row][col] = String.valueOf(node.val);
        dfs(arr, row + 1, left, col - 1, node.left);
        dfs(arr, row + 1, col + 1, right, node.right);
    }
    
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}