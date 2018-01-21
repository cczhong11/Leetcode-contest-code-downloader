def numOfPairs(nums, d):
    res = 0
    l, r = 0, 0
    while l < len(nums) - 1:
        while r < len(nums) - 1 and nums[r + 1] <= nums[l] + d:
            r += 1
            res += 1
        l += 1
        if r >= l:
            res += r - l
        else:
            r = l
    return res
        

class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        high = nums[-1] - nums[0]
        low = high
        for i in xrange(1, len(nums)):
            low = min(low, nums[i] - nums[i-1])
        while high > low:
            middle = (high + low) // 2
            if numOfPairs(nums, middle) < k:
                low = middle + 1
            else:
                high = middle
        return high