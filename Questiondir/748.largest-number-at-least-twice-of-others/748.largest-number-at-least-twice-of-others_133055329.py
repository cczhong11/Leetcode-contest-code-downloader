class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        t = max(nums)
        idx = -1
        for i in xrange(len(nums)):
            if t == nums[i]:
                idx = i
            else:
                if t < 2*nums[i]:
                    return -1
        return idx
        