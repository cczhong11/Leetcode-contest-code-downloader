class Solution(object):
    def strangePrinter(self, ss):
        """
        :type s: str
        :rtype: int
        """
        if len(ss) == 0:
            return 0
        s = ss[0]
        for c in ss:
            if c != s[-1]:
                s += c
        n = len(s)
        dp = [[0 for i in range(n)] for j in range(n)]
        for i in range(n):
            dp[i][i] = 1
            for j in range(i - 1, -1, -1):
                dp[j][i] = dp[j][i - 1] + 1
                for k in range(j, i):
                    if s[k] == s[i]:
                        dp[j][i] = min(dp[j][i], dp[j][k] + dp[k + 1][i - 1])
        return dp[0][n - 1]
                
        