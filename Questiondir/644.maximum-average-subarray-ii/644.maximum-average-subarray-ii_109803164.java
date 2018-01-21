public class Solution {
	public double findMaxAverage(int[] nums, int k) {
		double max = -10000;
		long[] init = new long[nums.length - k + 1];
		long sum = 0;
		for (int j = 0; j < k; j++) {
			sum += nums[j];
		}
		init[0] = sum;
		for (int j = k; j < nums.length; j++) {
			sum += nums[j];
			init[j-k+1] = sum;
		}
		for (int leng = k; leng <= nums.length; leng++) {
			long sumMax = init[leng - k];
			sum = sumMax;
			for (int i = leng; i < nums.length; i++) {
				sum = sum + nums[i] - nums[i-leng];
				if (sum > sumMax) {
					sumMax = sum;
				}
			}
			double avg = sumMax * 1.0 / leng;
			if (avg > max) {
				max = avg;
			}
		}
		return max;
	}
}