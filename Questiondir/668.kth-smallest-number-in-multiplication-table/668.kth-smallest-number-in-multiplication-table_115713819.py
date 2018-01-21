class Solution(object):
    def findKthNumber(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """
        def get_total(x):
            total = 0
            for i in range(1, m + 1):
                sub = min(x / i, n)
                if sub == 0:
                    break
                total += sub
            return total

        lo = 1
        hi = n * m
        while lo <= hi:
            mid = (lo + hi) / 2
            if lo == hi:
                return lo
            if k <= get_total(mid):
                hi = mid
            else:
                lo = mid + 1

