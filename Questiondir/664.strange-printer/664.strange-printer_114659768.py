class Solution(object):
    def strangePrinter(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = len(s)
        if l == 0:
            return 0
        dp = [[0]*l for _ in range(l)]
        for i in range(l):
            dp[i][i] = 1
        for i in range(1, l): #len
            for j in range(0, l-i): #start
                dp[j][j+i] = min(dp[j][j+i-1]+1, dp[j+1][j+i]+1)
                for k in range(0, i): #cut len
                    # print i, j, k, dp[j][j+i]
                    if s[j+k] == s[j+i]:
                        prev = 0 if k == 0 else dp[j][j+k-1]
                        dp[j][j+i] = min(dp[j][j+i], prev+dp[j+k][j+i-1])
        # print dp
        return dp[0][-1]