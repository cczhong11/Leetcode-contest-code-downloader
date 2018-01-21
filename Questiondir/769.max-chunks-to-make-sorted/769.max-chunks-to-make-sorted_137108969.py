class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        cnt = 0
        maxN = 0
        for i, n in enumerate(arr):
            maxN = max(maxN, n)
            if maxN == i:
                cnt += 1
                
        return cnt
            