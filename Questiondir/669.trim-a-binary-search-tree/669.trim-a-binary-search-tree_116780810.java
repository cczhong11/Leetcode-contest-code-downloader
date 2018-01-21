import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (L <= root.val && root.val <= R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        } else {
            TreeNode left = trimBST(root.left, L, R);
            TreeNode right = trimBST(root.right, L, R);
            return left != null ? left : right;
        }
    }
}
