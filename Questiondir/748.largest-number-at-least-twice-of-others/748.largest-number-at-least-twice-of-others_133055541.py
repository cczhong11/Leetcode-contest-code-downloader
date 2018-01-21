class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1: return 0
        x = sorted([(v,idx) for idx,v in enumerate(nums)])
        if x[-1][0] >= 2*x[-2][0]:
            return x[-1][1]
        else:
            return -1

