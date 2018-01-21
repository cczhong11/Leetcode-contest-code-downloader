class Solution:
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        N, r = len(arr), 0
        lo, hi = N, 0
        beg = 0
        for i, n in enumerate(arr):
            lo, hi = min(lo, n), max(hi, n)
            if beg == lo and hi == i:
                beg = i + 1
                r += 1
                lo, hi = N, 0
        return r