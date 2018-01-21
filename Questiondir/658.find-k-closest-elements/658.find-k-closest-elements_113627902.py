class Solution(object):
    def findClosestElements(self, arr, k, x):
        """
        :type arr: List[int]
        :type k: int
        :type x: int
        :rtype: List[int]
        """
        n = len(arr)
        start = 0
        end = n - 1
        while start + 1 < end:
            mid = start + (end - start) / 2
            if arr[mid] >= x:
                end = mid
            else:
                start = mid
        if arr[start] >= x:
            right = start
        elif arr[end] >= x:
            right = end
        else:
            right = n
        left = right - 1
        
        for i in xrange(k):
            if left < 0:
                right += 1
            elif right >= n:
                left -= 1
            elif abs(arr[left] - x) <= abs(arr[right] - x):
                left -= 1
            else:
                right += 1
        return arr[left + 1: right]
                
        