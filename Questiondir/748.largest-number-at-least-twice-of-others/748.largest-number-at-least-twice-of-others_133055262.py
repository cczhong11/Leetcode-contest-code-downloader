class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = max(nums)
        val = nums.index(res)
        nums.remove(res)
        return val if all(res >= 2*x for x in nums) else -1