class Solution:
    def maxChunksToSorted(self, arr):
        n = len(arr)
        if n==1:
            return 1
        max_arr = [0]*(n-1)
        min_arr = [0]*(n-1)
        max_arr[0] = arr[0]
        min_arr[-1] = arr[-1]
        for i in range(1,n-1):
            max_arr[i]=max(arr[i],max_arr[i-1])
            min_arr[n-i-2]=min(arr[n-i-1],min_arr[n-i-1])
        count = 1
        for i in range(n-1):
            if max_arr[i]<=min_arr[i]:
                count+=1
        return count
        """
        :type arr: List[int]
        :rtype: int
        """
        