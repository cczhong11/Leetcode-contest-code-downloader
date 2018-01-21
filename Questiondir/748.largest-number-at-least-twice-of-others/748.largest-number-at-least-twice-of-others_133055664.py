class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return -1
        max_idx = 0
        for i in xrange(1, len(nums)):
            if nums[i] > nums[max_idx]:
                max_idx = i
        for i in xrange(len(nums)):
            if i != max_idx and nums[max_idx] < nums[i] * 2:
                return -1
        return max_idx