class Solution:
    def maxChunksToSorted(self, arr):
        count = 0
        n = len(arr)
        mx = 0
        for i in range(n):
            if arr[i]>mx:
                mx = arr[i]
            if mx==i:
                count+=1
        return count
        """
        :type arr: List[int]
        :rtype: int
        """
        