class Solution {
    public int maxProfit(int[] prices, int fee) {
                if (prices.length<=1)return 0;
        int hold=-prices[0], release=0;
        for (int i=1;i<prices.length;++i){
            int p=prices[i];
            int oldHold = hold;
            hold=Math.max(release-p, hold);
            release=Math.max(release, oldHold+p-fee);
//            log.info("{}: hold: {}, release: {}", i, hold, release);
        }
        return Math.max(hold, release);
    }
}