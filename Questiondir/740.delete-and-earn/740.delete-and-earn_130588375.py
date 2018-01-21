class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == []: return 0
        maxi = max(nums)
        dp = [0] * (maxi + 1)
        a = [0] * (maxi + 1)
        for num in nums:
            a[num] += num
        nums = sorted(set(nums))
        for num in xrange(maxi + 1):
            dp[num] = max(dp[num - 1], dp[num - 2] + a[num])
        return dp[maxi]