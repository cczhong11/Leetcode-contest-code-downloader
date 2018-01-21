public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxavg = -Double.MAX_VALUE;
        int n = nums.length;
        for (; k <= n; k++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int max = sum;
            for (int i = k; i < n; i++) {
                sum += nums[i] - nums[i - k];
                if (sum > max) max = sum;
            }
            if (maxavg < (double)max / k)
                maxavg = (double)max / k;
            //System.out.println((double)max / k);
            //System.out.println(maxavg);
        }
        return maxavg;
    }
}