class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        cur_sum = max_sum = sum(nums[:k])
        for i in range(k, len(nums)):
            cur_sum = cur_sum - nums[i-k] + nums[i]
            max_sum = max(cur_sum, max_sum)
        return float(max_sum) / k
        