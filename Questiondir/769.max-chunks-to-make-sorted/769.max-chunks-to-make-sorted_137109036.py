class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        ans = 0
        st = 0
        while st < n:
            # find ed
            ed = arr[st]
            i = st
            while i <= ed:
                ed = max(ed, arr[i])
                i += 1
            ans += 1
            st = ed + 1
        return ans

