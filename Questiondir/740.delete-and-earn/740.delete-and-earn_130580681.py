class Solution:
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        counts = [0] * 10001
        # counts[i] stores the count of i
        for num in nums: counts[num] += 1
        # dp[i] stores the maximum sum towards now you can get by picking i
        max_with_me = [0] * 10001
        max_until_me = [0] * 10001
        for i in range(10001):
            max_with_me[i] = i * counts[i]
            if i >= 2:
                max_with_me[i] += max_until_me[i - 2]
            max_until_me[i] = max_with_me[i]
            if i >= 1:
                max_until_me[i] = max(max_until_me[i], max_until_me[i - 1])
        return max_until_me[10000]