import java.util.ArrayList;
import java.util.List;

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
    List<Long> sum = new ArrayList<>();
    List<Long> num = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        sum = new ArrayList<>();
        num = new ArrayList<>();
        solve(root, 0);
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < sum.size(); i++) {
            result.add(sum.get(i).doubleValue() / num.get(i));
        }
        return result;
    }

    private void solve(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= sum.size()) {
            sum.add(0L);
            num.add(0L);
        }
        sum.set(depth, sum.get(depth) + root.val);
        num.set(depth, num.get(depth) + 1);
        solve(root.left, depth + 1);
        solve(root.right, depth + 1);
    }
}