public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = findFixedMax(nums, k);
        for (int i = k + 1; i <= Math.min(nums.length, 2 * k); i++) {
            max = Math.max(max, findFixedMax(nums, i));
        }
        return max;
    }

    private double findFixedMax(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / k;        
    }
}