class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)
        max_mult = max([nums[-1] * nums[-2] * nums[-3],
                        nums[-1] * nums[0] * nums[1]])
        return max_mult