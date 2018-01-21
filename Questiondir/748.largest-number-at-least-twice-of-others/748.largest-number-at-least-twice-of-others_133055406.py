class Solution:
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums) <= 1:
            return -1
        
        val_index = -1
        val = max(nums)
        for i in range(len(nums)):
            if nums[i] == val:
                val_index = i
        
        nums.sort()
        if val >= 2 * nums[-2]:
            return val_index
        
        return -1
        
        