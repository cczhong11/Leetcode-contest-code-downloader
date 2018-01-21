class Solution(object):
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        nums = sorted(nums)
        
        pro1 = nums[0] * nums[1]
        
        return max(pro1*nums[-1], nums[-3]*nums[-2]*nums[-1])
        