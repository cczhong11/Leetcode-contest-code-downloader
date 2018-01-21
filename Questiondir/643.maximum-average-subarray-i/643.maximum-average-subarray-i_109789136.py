class Solution(object):
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        idx = k
        best = sum(nums[:k])
        cur = best
        while idx < len(nums):
            cur += nums[idx]
            cur -= nums[idx - k]
            best = max(best, cur)
            idx += 1
        return float(best) / k