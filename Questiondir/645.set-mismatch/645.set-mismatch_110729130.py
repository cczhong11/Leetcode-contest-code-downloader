class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        ref = {}
        cum = 0
        ret = []
        for n in nums:
            if n in ref:
                ret.append(n)
            else:
                ref[n] = 1
            cum += n
        missing = ret[0] + len(nums) * (len(nums) + 1)/2 - cum
        ret.append(missing)     
        return ret