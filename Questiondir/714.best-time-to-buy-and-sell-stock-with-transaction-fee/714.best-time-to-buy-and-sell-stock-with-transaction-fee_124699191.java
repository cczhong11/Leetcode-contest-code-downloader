class Solution {
    public int maxProfit(int[] prices, int fee) {
        // dp
        int buy = Integer.MIN_VALUE, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            int nextSell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = nextSell;
        }
        return sell;
    }
}