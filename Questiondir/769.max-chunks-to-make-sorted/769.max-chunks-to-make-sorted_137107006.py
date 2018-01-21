import collections
class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        alls = sorted(arr)
        a = collections.Counter()
        b = collections.Counter()
        ans = 0
        for i, n in enumerate(arr):
            a[n] += 1
            b[alls[i]] += 1
            if a == b:
                ans += 1
                a = collections.Counter()
                b = collections.Counter()
        return ans
