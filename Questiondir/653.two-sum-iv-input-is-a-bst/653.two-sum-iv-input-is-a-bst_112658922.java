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
    List<Integer> list;
    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        go(root);
        int left = 0, right = list.size() - 1;
        while (left < right) {
            long sum = list.get(left).longValue() + list.get(right).longValue();
            if (sum > k) {
                right--;
            } else if (sum < k) {
                left++;
            } else {
                return true;
            }
        }
        return false;
    }

    private void go(TreeNode node) {
        if (node == null) {
            return;
        }
        go(node.left);
        list.add(node.val);
        go(node.right);
    }
}