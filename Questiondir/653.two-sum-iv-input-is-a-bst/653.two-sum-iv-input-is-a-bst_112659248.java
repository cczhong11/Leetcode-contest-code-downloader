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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> sorted = new ArrayList<>();
        preOrder(root, sorted);
        int left = 0, right = sorted.size() - 1;
        while (left < right) {
            int sum = sorted.get(left) + sorted.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
    
    private void preOrder(TreeNode root, List<Integer> sorted) {
        if (root == null) {
            return;
        }
        preOrder(root.left, sorted);
        sorted.add(root.val);
        preOrder(root.right, sorted);
    }
}