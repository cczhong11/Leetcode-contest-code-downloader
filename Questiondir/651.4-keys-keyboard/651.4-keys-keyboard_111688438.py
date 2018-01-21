class Solution(object):
    def maxA(self, N):
        """
        :type N: int
        :rtype: int
        """
        if N <=4:
            return N
        
        dp = range(N+1)
        for i in xrange(5, N+1):
            tmp = i
            for j in xrange(0, i-3):
                tmp = max(tmp, dp[i-3-j]*(j+2))
            dp[i] = tmp
        
        return dp[N]