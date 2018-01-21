class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        
        int[] buy = new int[n], sell = new int[n];
        buy[0] = -prices[0];
        
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(sell[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(buy[i - 1] + prices[i] - fee, sell[i - 1]);
        }
        
        return sell[n - 1];
    }
}