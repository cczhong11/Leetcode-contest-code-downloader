class Solution(object):
    def maxA(self, N):
        dp = [0, 1, 2, 3]
        for i in range(4, N + 1):
            temp = dp[-1] + 1
            for k in range(i - 2):
                temp = max(temp, dp[i - k - 2] * (k + 1))
            dp.append(temp)
        #print dp
        return dp[N]