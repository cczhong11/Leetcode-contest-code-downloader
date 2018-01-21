public class Solution {
    public double findMaxAverage(int[] nums, int k) {
		double maxAvg = 0;
		long kSum = 0;
		for (int i = 0; i < nums.length; i++) {
			kSum += nums[i];
			if (i == k - 1) {
				maxAvg = kSum / (double) k;
			} else if (i >= k) {
				kSum -= nums[i - k];
				maxAvg = Math.max(maxAvg, (kSum / (double) k));
			}
		}
		return maxAvg;
    }
}