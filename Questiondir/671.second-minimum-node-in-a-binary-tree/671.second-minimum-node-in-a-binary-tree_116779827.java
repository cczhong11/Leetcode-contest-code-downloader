import java.util.*;
import java.math.*;
import java.util.stream.*;

class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

    }

    Integer res = null;

    public int findSecondMinimumValue(TreeNode root) {
        res = null;
        dfs(root, root.val);
        return res == null ? -1 : res;
    }

    private void dfs(TreeNode root, int min) {
        if (root == null) return;
        if (root.val == min) {
            dfs(root.left, min);
            dfs(root.right, min);
        } else {
            if (res == null || root.val < res) {
                res = root.val;
            }
        }
    }
}
