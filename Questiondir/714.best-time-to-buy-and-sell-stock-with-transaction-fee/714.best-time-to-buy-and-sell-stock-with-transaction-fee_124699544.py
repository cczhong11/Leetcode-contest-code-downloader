class Solution:
    def maxProfit(self, prices, fee):
        #a:持有， b:无
        a, b = -prices[0], 0
        for x in prices[1:]:
            a, b = max(a, b - x), max(a + x - fee, b)
        return max(a, b)
        