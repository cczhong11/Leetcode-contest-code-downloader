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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        int depth = getDepth(root);
        int[][] indexs = new int[depth][2];
        setMostIndex(root, 0, 1, indexs);
        int res = 0;
        for (int i = 0; i < depth; i++) {
            res = Math.max(res, indexs[i][1] - indexs[i][0] + 1);
        }
        return res;
    }

    int getDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }

    void setMostIndex(TreeNode node, int lev, int idx, int[][] indexs) {
        if (node == null) return;

        if (indexs[lev][0] == 0 || indexs[lev][0] > idx) {
            indexs[lev][0] = idx;
        }
        if (indexs[lev][1] == 0 || indexs[lev][1] < idx) {
            indexs[lev][1] = idx;
        }
        setMostIndex(node.left, lev + 1, idx * 2, indexs);
        setMostIndex(node.right, lev + 1, idx * 2 + 1, indexs);
    }
}