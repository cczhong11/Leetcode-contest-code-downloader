class Solution(object):
    def maxChunksToSorted(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        arr_sorted = sorted(arr)
        
        subsum, cur = 0, 0
        res = 0
        i = 0
        
        while i < len(arr):
            subsum += arr[i]
            cur += arr_sorted[i]
            if subsum == cur:
                res += 1
                subsum, cur = 0, 0       
            i += 1
        
        return res
        