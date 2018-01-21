class Solution:
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        large = max(nums)
        index = nums.index(large)
        for i, n in enumerate(nums):
            if i == index: continue
            if 2 * n > large:
                return -1
        return index