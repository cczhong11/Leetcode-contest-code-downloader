class Solution {
	public int deleteAndEarn(int[] nums) {
		int n = nums.length;
		if (n == 0) return 0;
		Map<Integer, Integer> sum = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum.put(nums[i], sum.getOrDefault(nums[i], 0) + nums[i]);
		}
		
		int m = sum.size();
		int[] b = new int[m];
		int i = 0;
		for (int key : sum.keySet()) {
			b[i++] = key;
		}
		Arrays.sort(b);
		
		int[][] dp = new int[m][2];
		
		dp[0][0] = 0;
		dp[0][1] = sum.get(b[0]);
		for (i = 1; i < m; i++) {
			if (b[i - 1] + 1 < b[i]) {
				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
				dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]) + sum.get(b[i]);
			} else {
				dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
				dp[i][1] = dp[i - 1][0] + sum.get(b[i]);
			}
		}
		return Math.max(dp[m - 1][0], dp[m - 1][1]);
	}
}