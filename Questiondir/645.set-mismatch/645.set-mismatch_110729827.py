class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        dup = None
        s = set()
        for n in nums:
            if n in s:
                dup = n
                break
            s.add(n)
        expect = len(nums) * (len(nums) + 1) / 2
        actual = sum(nums)
        return [dup, expect - actual + dup]