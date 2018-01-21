class Solution(object):
    def findDerangement(self, n):
        """
        :type n: int
        :rtype: int
        """
        m=1000000007
        dp=[0 for i in range(max(n+1,3))]
        dp[2]=1
        for i in range(3,n+1):
            dp[i]=(((i-1)*(dp[i-1]+dp[i-2]))%m)
        return dp[n]