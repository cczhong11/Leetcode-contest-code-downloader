public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        int n = nums.length;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > max) max = sum;
        }
        return (double)max / k;
    }
}