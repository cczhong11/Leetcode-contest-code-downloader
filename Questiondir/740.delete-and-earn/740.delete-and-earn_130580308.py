class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        e = [0 for i in range(10001)]
        for n in nums:
            e[n] += n
        dp0 = [0 for i in range(10001)]
        dp1 = [0 for i in range(10001)]
        for i in range(1, 10001):
            dp0[i] = max(dp0[i - 1], dp1[i - 1])
            dp1[i] = dp0[i - 1] + e[i]
        return max(dp0[-1], dp1[-1])