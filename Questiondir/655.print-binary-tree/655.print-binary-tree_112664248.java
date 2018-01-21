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
        int[] wh = getWH(root);
        String[][] ans = new String[wh[0]][wh[1]];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = "";
            }
        }
        draw(root, 0, wh[1] / 2, wh[1], ans);
        return getAns(ans);
    }
    List<List<String>> getAns(String[][] ans) {
        List<List<String>> rtn = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            List<String> buff = new ArrayList<>();
            for (int j = 0; j < ans[i].length; j++) {
                buff.add(ans[i][j]);
            }
            rtn.add(buff);
        }
        return rtn;
    }
    private void draw(TreeNode root, int row, int col, int w, String[][] board) {
        if (root == null) return;
        board[row][col] = Integer.valueOf(root.val).toString();
        int diff = (w + 1) / 4;
        draw(root.left, row + 1, col - diff, w / 2, board);
        draw(root.right, row + 1, col + diff, w / 2, board);
    }
    int[] getWH(TreeNode rt) {
        if (rt == null) return new int[]{0,0};
        int[] left = getWH(rt.left);
        int[] right = getWH(rt.right);
        int[] ans = new int[2];
        ans[0] = Math.max(left[0], right[0]) + 1;
        ans[1] = Math.max(left[1], right[1]) * 2 + 1;
        return ans;
    }
}