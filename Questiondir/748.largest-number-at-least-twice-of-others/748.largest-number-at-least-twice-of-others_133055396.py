class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        if not nums:
            return -1

        mi = -1

        for i in range(len(nums)):
            if mi == -1:
                mi = i
            elif nums[mi] < nums[i]:
                mi = i

        for i in range(len(nums)):
            if i == mi:
                continue
            if nums[i]*2>nums[mi]:
                return -1

        return mi
