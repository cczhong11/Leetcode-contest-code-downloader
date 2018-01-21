class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m=-1
        p=-1
        for i in range(len(nums)):
            if nums[i]>m:
                m=nums[i]
                p=i
        del nums[p]
        return p if all([m>=2*i for i in nums]) else -1