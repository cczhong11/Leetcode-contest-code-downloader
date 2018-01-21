class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mx = max(nums)
        mxi = nums.index(mx)
        others = [nums[i] for i in xrange(len(nums)) if i != mxi]
        return mxi if all(mx >= 2*o for o in others) else -1
        