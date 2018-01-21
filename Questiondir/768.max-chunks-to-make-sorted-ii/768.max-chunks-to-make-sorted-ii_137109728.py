class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        aSorted = sorted(arr)
        ans = 1
        end = 0
        mem = {}
        for i in range(len(aSorted)):
            if i > end:
                ans += 1
            targetIdx = None
            start = 0 if aSorted[i] not in mem else mem[aSorted[i]]
            for j in range(start, len(arr)):
                if arr[j] == aSorted[i]:
                    targetIdx = j
                    mem[aSorted[i]] = targetIdx+1
                    break
            if targetIdx > end:
                end = targetIdx
        return ans