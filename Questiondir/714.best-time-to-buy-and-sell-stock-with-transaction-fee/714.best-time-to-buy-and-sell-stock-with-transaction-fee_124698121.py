class Solution(object):
    def maxProfit(self, prices, fee):
        """
        :type prices: List[int]
        :type fee: int
        :rtype: int
        """
        dp = [[-100000000 for i in xrange(len(prices))] for j in xrange(2)]
        dp[0][0] = 0
        dp[1][0] = -prices[0]
        for i in xrange(1, len(prices)):
            dp[0][i] = max(dp[0][i-1], dp[1][i-1]+prices[i]-fee)
            dp[1][i] = max(dp[1][i-1], dp[0][i-1]-prices[i])
        return dp[0][len(prices)-1]
        