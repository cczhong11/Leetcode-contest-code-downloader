class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int n = prices.length;
        int res = 0;
        int max = prices[0], min = prices[0];
        for(int i = 1; i < n; i ++) {
            if(max > prices[i] + fee) {
                if(max - min - fee > 0) {
                    res += max - min - fee;
                }
                max = prices[i];
                min = prices[i];
            }else {
                max = Math.max(prices[i], max);
                if(min > prices[i]) {
                    min = prices[i];
                    max = prices[i];
                }
            }
        }
        if(max - min - fee > 0)
            res += max - min - fee;
        return res;
    }
}