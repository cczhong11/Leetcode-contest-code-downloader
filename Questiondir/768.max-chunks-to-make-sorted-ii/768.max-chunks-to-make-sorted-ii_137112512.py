class Solution:
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        N = len(arr)
        m = collections.defaultdict(list)
        for i, n in enumerate(sorted(arr, reverse=True)):
            m[n].append(N - i - 1)
        r = 0
        lo, hi = N, 0
        beg = 0
        for i, n in enumerate(arr):
            n = m[n].pop()
            lo, hi = min(lo, n), max(hi, n)
            if beg == lo and hi == i:
                beg = i + 1
                r += 1
                lo, hi = N, 0
        return r