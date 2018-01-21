class Solution(object):
    def pivotIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        ps=[0]*(n+1)
        for i in xrange(n):
            ps[i+1]=ps[i]+nums[i]
        for i in xrange(n):
            if ps[i]+ps[i+1]==ps[-1]:
                return i
        return -1