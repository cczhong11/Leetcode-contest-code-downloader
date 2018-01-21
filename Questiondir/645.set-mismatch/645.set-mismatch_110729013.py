class Solution(object):
    def findErrorNums(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        cnt = [0] * (n+1)
        for x in nums:
            cnt[x] += 1
        ret = []
        for i in xrange(1, n+1):
            if cnt[i] == 2:
                ret.append(i)
                break
        for i in xrange(1, n+1):
            if cnt[i] == 0:
                ret.append(i)
                break
        return ret

