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
    public boolean checkEqualTree(TreeNode root) {
        Map<TreeNode, Integer> sumMap = new HashMap<>();
        int totalSum = getSum(root, sumMap);

        if (sumMap.size() == 1 || (Math.abs(totalSum) & 1) != 0) return false;
        
        for (TreeNode node : sumMap.keySet()) {
            if (sumMap.get(node) == totalSum / 2) return true;
        }
        return false;
    }

    public int getSum(TreeNode node, Map<TreeNode, Integer> sumMap) {
        if (node == null) return 0;
        int sum = node.val + getSum(node.left, sumMap) + getSum(node.right, sumMap);
        sumMap.put(node, sum);
        return sum;
    }
}