class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        def dfs(a):
            for i in range(1, len(a)):
                l, r = a[:i], a[i:]
                if max(l) <= min(r):
                    return 1 + dfs(l) + dfs(r)
            return 0
        return dfs(arr) + 1
                