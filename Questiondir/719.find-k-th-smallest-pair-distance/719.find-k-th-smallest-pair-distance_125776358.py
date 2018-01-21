from bisect import bisect
class Solution:
    def smallestDistancePair(self, arr, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(arr)
        arr.sort()
        def countpairs(arr,diff,n):
            res = 0
            for i in range(n):
                pos = bisect(arr,arr[i]+diff)
                res += (pos-i-1)
            return res
        
        maxd = arr[n-1]-arr[0]
        mind = maxd
        for i in range(n-1): mind = min(mind,arr[i+1]-arr[i])
        while mind<maxd:
            mid = (mind+maxd)>>1
            count = countpairs(arr,mid,n)
            if count<k: mind = mid + 1
            else: maxd = mid
        return(mind)