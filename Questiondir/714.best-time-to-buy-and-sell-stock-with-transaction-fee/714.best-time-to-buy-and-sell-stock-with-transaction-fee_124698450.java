class Solution {
    public int maxProfit(int[] prices, int fee) {
        int max=0;
        int profit=-prices[0]-fee;
        for(int i=1;i<prices.length;i++){
            int newProfit=Math.max(profit,max-prices[i]-fee);
            max=Math.max(max,prices[i]+profit);
            profit=newProfit;
        }
        return max;
    }
}