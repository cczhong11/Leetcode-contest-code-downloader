public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double min = Integer.MAX_VALUE;
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (max - min > 1.e-6) {
            double mid = (max + min) / 2.;
            if (valid(nums, mid, k)) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return min;
    }
    // 判断是否存在k个连续的数组和满足要求。用连续和的算法
    private boolean valid(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i] - mid;
        }        
        double minsum = 0;
        for (int i = k; i < sum.length; i++) {
            minsum = Math.min(sum[i - k], minsum);
            if (sum[i] - minsum >= 0) {
                return true;
            }
        }
        return false;
    }
}