class Solution {
    public int maxProfit(int[] prices, int fee) {
        int stock = Integer.MIN_VALUE / 2;
        int cash = 0;
        for (int p : prices) {
            int new_cash = Math.max(cash, stock + p - fee);
            int new_stock = Math.max(stock, cash - p);
            cash = new_cash;
            stock = new_stock;
        }
        return cash;
    }
}