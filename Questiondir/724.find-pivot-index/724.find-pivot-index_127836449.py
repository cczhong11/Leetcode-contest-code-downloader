class Solution:
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if not nums:
            return -1
        
        if len(nums) == 1:
            return 0
        
        
        s = 0
        for n in nums:
            s += n
            
        if s - nums[0] == 0:
            return 0
        
        
        t = 0
        
        for i in range(len(nums)):
            if i > 0:
                t += nums[i-1]
                if s - t - nums[i] == t:
                    return i
        return -1
        
        
        