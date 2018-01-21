import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    private void dfs(TreeNode root, int d, int v) {
        if (root == null)
            return;
        if (d == 2) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        } else {
            dfs(root.left, d - 1, v);
            dfs(root.right, d - 1, v);
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        } else {
            dfs(root, d, v);
            return root;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        sol.addOneRow(node, 3, 3);
    }

}