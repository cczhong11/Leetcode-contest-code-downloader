class Solution(object):
    def helper(self, nums, target, default):
        #print nums
        if not nums and target == 0:
            return True
        if target == 0:
            target = default
        for i in range(len(nums)):
            if nums[i] <= target and \
            self.helper(nums[0:i] + nums[i+1:], target - nums[i], default):
                         return True
        return False
    
    def canPartitionKSubsets(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if not nums: return False
        total = sum(nums)
        if total % k != 0:
            return False
        target = total / k
        nums = sorted(nums)[::-1]
        if nums[0] > target:
            return False
        return self.helper(nums, target, target)
        
        