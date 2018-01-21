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
    ArrayList<Integer> all;
    
    int getSum(TreeNode root) {
        if (root == null) return 0;
        int res = root.val;
        res += getSum(root.left);
        res += getSum(root.right);
        all.add(res);
        return res;
    }
    
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        all = new ArrayList<>();
        int sum = getSum(root);
        int zero = 0;
        boolean res = false;
        for (int x : all) {
            if (x == 0) zero++;
            if (x * 2 == sum) res = true;
        }
        if (res) {
            return sum != 0 || sum == 0 && zero > 1;
        }
        return false;
    }
}