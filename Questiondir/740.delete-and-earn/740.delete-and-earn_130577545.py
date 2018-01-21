class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        tmp2 = collections.defaultdict(int)
        tmp = collections.Counter(nums)
        for i in tmp.keys():
            tmp2[i] = i * tmp[i]
        dp = [0, 0]
        for i in range(10000):
            dp[0], dp[1] = max(dp[0], dp[1]), tmp2[i] + dp[0]
        return max(dp)
        