import operator
class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)<=3: return reduce(operator.mul, nums, 1)
        nums = sorted(nums)
        return max(nums[-1]*nums[-2]*nums[-3], nums[0]*nums[1]*nums[-1])