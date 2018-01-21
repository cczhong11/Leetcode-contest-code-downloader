class Solution {
    public int maxProfit(int[] prices, int fee) {
        int res = 0;
        int pre = 0;
        for (int i : prices) {
            if (pre == 0 || i + fee < pre) {
                pre = i + fee;
                continue;
            }
            if (i - pre > 0) {
                res += i - pre;                
                pre = i;
            }
        }
        return res;
    }
}