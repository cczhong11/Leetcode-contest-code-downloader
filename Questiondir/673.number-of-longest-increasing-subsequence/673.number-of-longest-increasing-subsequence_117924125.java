class Solution {
 	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int n = nums.length;
		int[] dp = new int[n];
		int[] count = new int[n];
		
		dp[0] = 1;
		count[0] = 1;
		int ansMax = 1;
		int ansCount = 0;
		for (int i = 1; i < n; i++) {
			int max = 1;
			
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[j] < nums[i] && dp[j] + 1 == max) {
					count[i] += count[j];
				}
			}
			if (max == 1) {
				count[i] = 1;
			}
			if (ansMax < max) {
				ansMax = max;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (dp[i] == ansMax) {
				ansCount += count[i];
			}
		}
		
		
		
		return ansCount;
	}
	
}