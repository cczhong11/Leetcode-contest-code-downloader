import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        if (list.size() < 2) return false;

        for (int i = 0, j = list.size() - 1; i < j; )
            if (list.get(i) + list.get(j) == k)
                return true;
            else if (list.get(i) + list.get(j) > k)
                j--;
            else
                i++;
        return false;
    }
}