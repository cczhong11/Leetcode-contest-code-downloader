class Solution(object):
    def findKthNumber(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """
        left = 1
        right = m*n
        if m < n:
            tmp = n
            n = m
            m = tmp
        while left < right:
            mid = (left+right)/2
            num = 0
            for i in range(1, n+1):
                num += min(mid/i, m)
            if num < k:
                left = mid + 1
            else:
                right = mid
        print left
        ans = -1
        for i in range(1, n+1):
            if i*(left/i) > ans:
                ans = i*(left/i)
        return ans
                