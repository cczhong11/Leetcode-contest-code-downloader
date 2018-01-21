class Solution(object):
    def dominantIndex(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        m = max(nums)
        idx = -1
        cnt = 0
        for i, c in enumerate(nums):
            if c == m:
                idx = i
            if c > m/2:
                cnt +=1
        if cnt == 1:
            return idx
        return -1