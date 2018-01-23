import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root)[0];
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, -1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int max = Math.max(left[0], right[0]);
        max = Math.max(max, left[1] + right[1] + 2);
        int height = Math.max(left[1], right[1]) + 1;

        return new int[]{max, height};
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(sol.diameterOfBinaryTree(root));
    }
}