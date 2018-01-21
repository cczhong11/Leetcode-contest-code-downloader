public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for(int i = 0; i < k; ++ i) {
            sum += nums[i];
        }
        long r = sum;
        for(int i = k; i < nums.length; ++ i) {
            r -= nums[i - k];
            r += nums[i];
            if(r > sum) {
                sum = r;
            }
        }
        return 1.0 * sum / k;
    }
}