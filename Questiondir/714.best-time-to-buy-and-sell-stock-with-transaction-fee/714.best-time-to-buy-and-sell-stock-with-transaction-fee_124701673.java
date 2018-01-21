class Solution {
    public int maxProfit(int[] prices, int fee) {
		if (prices.length < 2) {
			return 0;
		}
		int[] noHolds = new int[prices.length];
		int[] holds = new int[prices.length];
		noHolds[0] = 0;
		holds[0] = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			noHolds[i] = Math.max(holds[i - 1] + prices[i] - fee, noHolds[i - 1]);
			holds[i] = Math.max(holds[i - 1], noHolds[i - 1] - prices[i]);
		}
		return noHolds[prices.length - 1];
    }
}