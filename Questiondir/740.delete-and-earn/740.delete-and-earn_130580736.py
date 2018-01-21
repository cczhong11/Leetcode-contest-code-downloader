from collections import Counter

class Solution:
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if not nums:
            return 0
        
        cnt = Counter(nums)        
        
        dp = [[0 for j in range(2)] for i in range(10001)]
        
        dp[0][0] = 0
        dp[0][1] = -1
        
        max_val = 0
        
        for i in range(1, 10001):
            # Pick it
            if dp[i-1][0] != -1:
                dp[i][1] = dp[i-1][0] + cnt[i] * i
            # Don't pick it
            dp[i][0] = dp[i-1][0]
            if dp[i-1][1] != -1:
                dp[i][0] = max(dp[i][0], dp[i-1][1])
        
            max_val = max(max_val, max(dp[i][0], dp[i][1]))
        
        return max_val