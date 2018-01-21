class Solution(object):
    def findDerangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        # d(n) = d(n-2)*(n-1) + d(n-1)*(n-1)
        dp = [0]*max(3,n+1)
        dp[2] = 1
        for i in xrange(3, n+1):
            dp[i] = ((i-1)*(dp[i-1]+dp[i-2])) % 1000000007
        return dp[n]