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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        List<Double> average = new ArrayList<Double>();
        getAverage(root, nums, average, 0);
        return average;
    }
    public void getAverage(TreeNode root, List<Integer> nums, List<Double> average, int level) {
        if (root == null) {
            return ;
        }
        if (nums.size() == level) {
            nums.add(1);
            average.add((double)root.val);
        }
        else {
            int curNum = nums.get(level);
            double res = curNum * average.get(level) + root.val;
            res /= curNum + 1;
            nums.set(level, curNum + 1);
            average.set(level, res);
        }
        getAverage(root.left, nums, average, level + 1);
        getAverage(root.right, nums, average, level + 1);
    }
}