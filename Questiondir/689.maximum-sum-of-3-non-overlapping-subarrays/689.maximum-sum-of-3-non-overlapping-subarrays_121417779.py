class Solution(object):
    def maxSumOfThreeSubarrays(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        ksum = [0] * len(nums)
        ksum[0] = sum(nums[:k])
        
        for i in xrange(1, len(nums)-k+1):
            ksum[i] = ksum[i-1] - nums[i-1] + nums[i+k-1]
            
        dp = [(0,0)] * (len(nums)+1)
        for i in xrange(k, len(nums)+1):
            startPos = i-k
            pervMax, pervPos = dp[i-1]
            if ksum[startPos] > pervMax:
                dp[i] = (ksum[startPos], startPos)
            else:
                dp[i] = dp[i-1]
                
        dp2 = [(0,0)] * (len(nums)+1)
        for i in xrange(k*2, len(nums)+1):
            startPos = i-k
            pervMax, pervPos = dp2[i-1]
            newMax = ksum[startPos]+dp[startPos][0]
            if newMax > pervMax:
                dp2[i] = (newMax, (dp[startPos][1], startPos))
            else:
                dp2[i] = dp2[i-1]
                
        dp3 = [(0,0)] * (len(nums)+1)
        rvMax, rvPos = 0, 0
        for i in xrange(k*3, len(nums)+1):
            startPos = i-k
            pervMax, pervPos = dp3[i-1]
            newMax = ksum[startPos]+dp2[startPos][0]
            if newMax > pervMax:
                x = dp2[startPos][1]
                dp3[i] = (newMax, (x[0], x[1], startPos))
            else:
                dp3[i] = dp3[i-1]
                
        return dp3[-1][1]