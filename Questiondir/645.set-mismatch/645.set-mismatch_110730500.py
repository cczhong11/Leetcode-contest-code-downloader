class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        ans = [0, 0]
        cnt = [0] * len(nums)
        for i in nums:
            cnt[i-1] += 1
        for i in xrange(len(nums)):
            if cnt[i] == 0:
                ans[1] = i+1
            elif cnt[i] == 2:
                ans[0] = i+1
        return ans
        
        
        