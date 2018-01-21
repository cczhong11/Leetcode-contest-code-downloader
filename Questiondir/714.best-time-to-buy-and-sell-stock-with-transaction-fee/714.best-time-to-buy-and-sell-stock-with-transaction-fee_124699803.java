class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] profit = new int[prices.length][2];
        profit[prices.length - 1][0] = 0;
        profit[prices.length - 1][1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            profit[i][0] = Math.max(profit[i+1][0], - fee - prices[i] + profit[i+1][1]);
            profit[i][1] = Math.max(prices[i] + profit[i+1][0], profit[i+1][1]);
        }
        return profit[0][0];
    }
}