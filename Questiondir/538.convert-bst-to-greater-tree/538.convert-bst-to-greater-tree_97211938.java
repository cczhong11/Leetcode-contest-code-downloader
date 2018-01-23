import java.io.*;
import java.util.*;
import java.math.*;
import java.util.stream.*;

public class Solution {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        cnt = 0;
        dfs(root);
        return root;
    }

    int cnt = 0;

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        int tmp = root.val;
        root.val += cnt;
        cnt += tmp;
        dfs(root.left);
    }

    private static void print(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        print(sol.convertBST(root));
    }
}