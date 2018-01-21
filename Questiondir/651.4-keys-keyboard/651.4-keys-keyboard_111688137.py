class Solution(object):
    def maxA(self, N):
        """
        :type N: int
        :rtype: int
        """
        dp = [i for i in range(N+1)]
        for i in range(N+1):
            for j in range(3, 7):
                if i >= j:
                    dp[i] = max(dp[i], dp[i - j]*(j - 1))
        return dp[N]