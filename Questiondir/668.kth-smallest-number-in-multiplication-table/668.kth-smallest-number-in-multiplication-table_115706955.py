class Solution(object):
    def findKthNumber(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """
        def count(num):
            cnt = 0
            for i in range(m):
                cnt += min(num / (i + 1), n)
            return cnt
        l = 1
        r = 30000 * 30000 + 1
        while l < r:
            num = l + r >> 1
            if count(num) < k:
                l = num + 1
            else:
                r = num
        return l