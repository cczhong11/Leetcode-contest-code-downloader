class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        value = [0 for _ in range(10001)]
        
        for ele in nums:
            value[ele] += ele
        
        res = 0
        dp = [0 for _ in range(10001)]
        dp[1] = value[1]
        for i in range(2,10001):
            dp[i] = value[i] + max(dp[i-2],dp[i-3])
        return max(dp)
        
        