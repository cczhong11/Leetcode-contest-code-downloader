class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        aSorted = sorted(arr)
        ans = 1
        end = 0
        for i in range(len(arr)):
            if i > end:
                ans += 1
            targetIdx = None
            for j in range(len(aSorted)):
                if aSorted[j] == arr[i]:
                    targetIdx = j
                    break
            if targetIdx > end:
                end = targetIdx
                
        return ans