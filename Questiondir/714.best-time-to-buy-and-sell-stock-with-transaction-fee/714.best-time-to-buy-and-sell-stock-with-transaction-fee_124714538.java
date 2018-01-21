class Solution {
	public int maxProfit(int[] prices, int fee) {
		int ans = 0;
		int n = prices.length;
		
		int[] dp = new int[n + 1];
		int max = Integer.MIN_VALUE;
		dp[0] = 0;
		max = -prices[0] - fee;
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], max + prices[i]);
			max = Math.max(dp[i - 1] - prices[i] - fee, max);
		}
		return dp[n - 1];
	}
}