class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        d = {}
        ans = 0
        k = 0
        d[0] = -1
        for i in range(len(nums)):
            l = nums[i]
            if l == 0:
                k -= 1
            else:
                k += 1
            if k in d:
                if i - d[k] > ans:
                    ans = i - d[k]
            else:
                d[k] = i
        return ans